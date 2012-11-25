package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable

@Immutable
// @Invariant({ ! isAbstract && isFinal }) // Can't have invariant and immutable. :(
public class Method {
	String className
	String methodName

	String signature

	boolean isFinal
	boolean isAbstract

	@Override
	String toString() {
		String prefix = isAbstract ? "abstract " :isFinal ? "final " : "";
		return "Method( $prefix$className.$methodName $signature )"
	}
}
