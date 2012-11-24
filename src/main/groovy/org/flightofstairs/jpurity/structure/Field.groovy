package org.flightofstairs.jpurity.structure;

import groovy.transform.Immutable;

@Immutable
class Field {
	String className
	String fieldName

	boolean refEffectivelyImmutable

	Field confirmRefImmutable() { new Field(className, fieldName, true) }
}
