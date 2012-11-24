package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable

@Immutable
class Access {
	Method method
	Field field

	String toString() {
		return "Access( $method -> $field )"
	}
}
