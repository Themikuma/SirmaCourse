package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * A class that creates big, bulky objects. It needs a proxy.
 * 
 * @author gdimitrov
 */
public class BigObjects {
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
	public BigObjects(String field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	/**
	 * Does some complex work that takes a long time.
	 */
	public void doWork() {
	}
}
