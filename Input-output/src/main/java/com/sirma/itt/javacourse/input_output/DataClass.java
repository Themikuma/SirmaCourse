package com.sirma.itt.javacourse.input_output;

import java.io.Serializable;

/**
 * A user defined serializable class.
 * 
 * @author gdimitrov
 */
public class DataClass implements Serializable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 139575705425548523L;

	private int value1;
	String value2;
	protected int value3;

	/**
	 * Give some random values to the fields.
	 */
	public DataClass() {
		value1 = 5;
		value2 = "Hello";
		value3 = 15;
	}
}
