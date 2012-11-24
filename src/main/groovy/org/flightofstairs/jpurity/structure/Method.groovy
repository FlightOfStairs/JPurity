package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable;

@Immutable
public class Method {
	String className
	String methodName

	String signature

	Set<Field> reads
	Set<Field> writes

	def Method reads(Field field) { new Method(className, methodName, signature, reads.plus(field), writes) }
	def Method writes(Field field) { new Method(className, methodName, signature, reads, writes.plus(field)) }

	String toString() {
		return "Method( $className.$methodName $signature )"
	}
}
