package com.sirma.itt.javacourse.designpatterns;

/**
 * Implementation of the Singleton design pattern.
 * 
 * @author gdimitrov
 */
public final class Singleton {
	private static Singleton object;

	/**
	 * Constructor should only be accessible from within the class.
	 */
	private Singleton() {
	}

	/**
	 * Gets an instance of the class. Can only get one instance.
	 * 
	 * @return an instance of the class.
	 */
	public static Singleton getInstance() {
		if (object == null) {
			object = new Singleton();
		}
		return object;
	}
}
