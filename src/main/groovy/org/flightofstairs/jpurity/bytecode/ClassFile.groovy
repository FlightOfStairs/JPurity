package org.flightofstairs.jpurity.bytecode

import groovy.transform.Synchronized
import org.flightofstairs.jpurity.structure.Access
import org.flightofstairs.jpurity.structure.Call
import org.flightofstairs.jpurity.structure.Field
import org.flightofstairs.jpurity.structure.Method
import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.Attribute
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

import static org.objectweb.asm.Opcodes.*

final class ClassFile {
	private final URL url

	private boolean parsed = false

	private final Set<Field> fields = []

	private final Set<Method> methods = []
	private final Set<Call> calls = []

	private final Set<Access> reads = []
	private final Set<Access> writes = []

	private ClassFile(URL url) {
		this.url = url
	}

	static ClassFile forUrl(URL url) {
		new ClassFile(url)
	}

	public Set<Method> getFields() { parse(); Collections.unmodifiableSet(fields) }

	public Set<Method> getMethods() { parse(); Collections.unmodifiableSet(methods) }

	/**
	 * Get the calls made from methods within this class.
	 * @return Set of Calls. IMPORTANT: It is not known whether called methods are final or abstract. Non-INVOKEINTERFACE/INVOKEDYNAMIC called methods are always considered not-abstract, which is a lie.
	 */
	public Set<Call> getCalls() { parse(); Collections.unmodifiableSet(calls) }

	/**
	 * Get read accesses within class methods.
	 * @return Set of Accesses representing reads. IMPORTANT: since finality of external vars is not known now, ALL Accesses' fields are considered not-final.
	 */
	public Set<Access> getReads() { parse(); Collections.unmodifiableSet(reads) }
	public Set<Access> getWrites() { parse(); Collections.unmodifiableSet(writes) }


	@Synchronized
	private void parse() {
		if(parsed) return;

		def bytecodeStream = null

		try {
			bytecodeStream = url.openStream();

			ClassReader classReader = new ClassReader(bytecodeStream)

			classReader.accept(new ClassVisitor(Opcodes.ASM4) {
				@Override
				FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
					def isFinal = (access & ACC_FINAL) != 0

					fields << new Field(classReader.getClassName(), name, isFinal)

					return new FieldVisitor(Opcodes.ASM4) {	}
				}

				@Override
				MethodVisitor visitMethod(int visibility, String methodName, String methodDesc, String signature, String[] exceptions) {
					def isFinal = (classReader.getAccess() & ACC_FINAL) != 0 || (visibility & ACC_FINAL) != 0
					def isAbstract = (visibility & ACC_ABSTRACT) != 0

					def method = new Method(classReader.getClassName(), methodName, methodDesc, isFinal, isAbstract)
					methods << method
					return createMethodVisitor(method)
				}

			}, 0)
		} finally {
			bytecodeStream.close()
		}

		parsed = true;
	}

	private MethodVisitor createMethodVisitor(final method) {
		new MethodVisitor(Opcodes.ASM4) {

			@Override
			void visitMethodInsn(int opcode, String owner, String invokedName, String invokedDesc) {
				def isAbstractCall = [INVOKEINTERFACE, INVOKEDYNAMIC].contains(opcode) //TODO better identification of abstract methods

				Method called = new Method(owner, invokedName, invokedDesc, false, isAbstractCall)
				calls << new Call(method, called)
			}

			@Override
			void visitFieldInsn(int opCode, String owner, String fieldName, String fieldDesc) {
				def isRead = [GETSTATIC, GETFIELD].contains(opCode)

				Access access = new Access(method, new Field(owner, fieldName, false))

				if (isRead) reads << access
				else writes << access
			}
		}
	}
}
