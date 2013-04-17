package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

/**
 * This is the parent class for the hierarchy that is going to be sorted using annotations.
 * 
 * @author gdimitrov
 */
@Hierarchy(0)
public class CustomParent {
	/**
	 * Prints the current class that is calling the function.
	 */
	public void printClass() {
		System.out.println(this.getClass());
	}
}
