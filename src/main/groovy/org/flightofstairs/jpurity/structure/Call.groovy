package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable

@Immutable
class Call {
	Method caller
	Method callee

	boolean isAbstract

	String toString() {
		def abstractText = isAbstract ? " abstract" : ""
		return "Call($abstractText $caller -> $callee )"
	}
}
