/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.composite;

/**
 * A leaf is an object that doesn't have any children.
 * 
 * @author Georgi
 */
public class Product implements Element {

	private int value;

	@Override
	public int getTotalPrice() {
		return getValue();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
