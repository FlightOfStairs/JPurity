package org.flightofstairs.jpurity.structure

import groovy.transform.Immutable;

@Immutable
public class Method {
	String className
	String methodName

	String signature

	boolean isFinal
	boolean isAbstract

	String toString() {
		return "Method( $className.$methodName $signature )"
	}
}
