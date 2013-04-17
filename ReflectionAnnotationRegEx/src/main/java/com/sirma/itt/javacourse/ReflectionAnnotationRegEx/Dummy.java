package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

/**
 * This is a dummy class that is going to be used to demonstrate reflection.
 * 
 * @author gdimitrov
 */
public class Dummy {
	/**
	 * Setting some random values to properties.
	 */
	public Dummy() {
		privateProperty = 5;
		defaultProperty = true;
		protectedProperty = 22;
		publicProperty = -2;
	}

	/**
	 * A private property.
	 */
	private int privateProperty;

	/**
	 * A property with default access.
	 */
	boolean defaultProperty;

	/**
	 * A property with protected access.
	 */
	protected int protectedProperty;

	/**
	 * A property with public access.
	 */
	public int publicProperty;

	/**
	 * A method with private access.
	 */
	private void privateMethod() {
		System.out.println("You have invoked a private method");
	}

	/**
	 * A method with default access.
	 */
	void defaultMethod() {
		System.out.println("You have invoked a default method");
	}

	/**
	 * A method with protected access.
	 */
	protected void protectedMethod() {
		System.out.println("You have invoked a protected method");
	}

	/**
	 * A method with public access.
	 */
	public void publicMethod() {
		System.out.println("You have invoked a public method");
	}

}
