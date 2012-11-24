package org.flightofstairs.jpurity.structure;

import groovy.transform.Immutable;

@Immutable
class Field {
	String className
	String fieldName

	boolean isFinal

	String toString() {
		return "Field( " + (isFinal?  "final " : "") + "$className.$fieldName )"
	}
}
