package com.sirma.itt.javacourse.designpatterns;

/**
 * @author gdimitrov
 */
public final class IntegerFactory {
	/**
	 * Private constructor for utility classes.
	 */
	private IntegerFactory() {
	}

	/**
	 * Creates an instance of the {@link Proxy} class.
	 * 
	 * @return instance of {@link Proxy}.
	 */
	public static Proxy createInstance() {
		return new Proxy("This is", " Sparta");
	}
}
