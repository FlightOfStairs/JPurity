package org.flightofstairs.jpurity.bytecode

import org.flightofstairs.jpurity.structure.Call
import org.flightofstairs.jpurity.structure.Method
import org.junit.Assert
import org.junit.Test

import static org.junit.Assert.*

class ClassFileTest {
	@Test
	def void testCalls() {
		ClassFile classFile = ClassFile.forUrl(ClassFileTest.getResource("/About.clazz"))

		Method init = new Method("org/flightofstairs/plaintwitterwidget/About", "<init>", "()V", [] as Set, [] as Set)
		Method onCreate = new Method("org/flightofstairs/plaintwitterwidget/About", "onCreate", "(Landroid/os/Bundle;)V", [] as Set, [] as Set)

		Set<Method> expectedKeys = [init, onCreate]

		def calls = classFile.calls()

		assertEquals(expectedKeys, calls.keySet())

		Set<Call> expectedInitCalls = [ new Call(init, new Method("android/app/Activity", "<init>", "()V", [] as Set, [] as Set), false) ]

		assertEquals(expectedInitCalls, calls[init])

		assertEquals(5, calls[onCreate].size())
		assertTrue(calls[onCreate].contains(new Call(onCreate, new Method("android/preference/PreferenceManager", "getDefaultSharedPreferences", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", [] as Set, [] as Set), false)))
	}
}