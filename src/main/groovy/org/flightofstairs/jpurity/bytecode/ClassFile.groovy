package org.flightofstairs.jpurity.bytecode

import org.flightofstairs.jpurity.structure.Call
import org.flightofstairs.jpurity.structure.Method
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

import static org.objectweb.asm.Opcodes.INVOKEDYNAMIC
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;

final class ClassFile {
	private final URL url

	public static ClassFile forUrl(URL url) { new ClassFile(url) }
	private ClassFile(URL url) { this.url = url }

	public Map<Method, Set<Call>> calls() {
		def callMap = [:]

		def bytecodeStream = null

		try {
			bytecodeStream = url.openStream();

			ClassReader classReader = new ClassReader(bytecodeStream)

			classReader.accept(new ClassVisitor(Opcodes.ASM4) {
				@Override
				MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
					def method = new Method(classReader.getClassName(), name, desc, [] as Set, [] as Set)

					callMap[method] = [] as Set

					return new MethodVisitor(Opcodes.ASM4) {
						@Override
						void visitMethodInsn(int opcode, String owner, String invokedName, String invokedDesc) {

							def isAbstractCall = [INVOKEINTERFACE, INVOKEDYNAMIC].contains(opcode) //TODO better identification of abstract methods

							Method called = new Method(owner, invokedName, invokedDesc, [] as Set, [] as Set)

							callMap[method] << new Call(method, called, isAbstractCall)

							super.visitMethodInsn(opcode, owner, invokedName, invokedDesc)
						}
					}
				}
			}, 0)

		} finally {
			bytecodeStream.close()
		}

		return callMap
	}
}
