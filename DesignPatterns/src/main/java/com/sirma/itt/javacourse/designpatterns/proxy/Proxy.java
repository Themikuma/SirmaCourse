package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The actual class.
 * 
 * @author gdimitrov
 */
public class Proxy {
	private String field1;
	private String field2;

	/**
	 * Creates an object, that takes a long time to create. And takes up a lot of space in the
	 * operating memory.
	 * 
	 * @param field1
	 *            the value of the first field
	 * @param field2
	 *            the value of the second field
	 */
	public Proxy(String field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	/**
	 * Does some complex work that takes a long time.
	 */
	public void doWork() {
	}
}
