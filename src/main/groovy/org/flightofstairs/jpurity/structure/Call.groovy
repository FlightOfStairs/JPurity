package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable

@Immutable
class Call {
	Method caller
	Method callee

	String toString() {
		return "Call( $caller -> $callee )"
	}
}
