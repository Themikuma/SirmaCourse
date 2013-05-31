package com.sirma.itt.javacourse.designpatterns.proxy;


/**
 * @author gdimitrov
 */
public final class BigObjectsFactory {
	/**
	 * Private constructor for utility classes.
	 */
	private BigObjectsFactory() {
	}

	/**
	 * Creates an instance of the {@link BigObjects} class.
	 * 
	 * @return instance of {@link BigObjects}.
	 */
	public static BigObjects createInstance() {
		return new BigObjects("This is", " Sparta");
	}
}
