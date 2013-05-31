/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.composite;

import java.util.ArrayList;

/**
 * This is the composite item.
 * 
 * @author Georgi
 */
public class Products implements Element {

	private int value;
	private ArrayList<Element> products;

	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		totalPrice += getValue();
		for (Element product : products) {
			totalPrice += product.getTotalPrice();
		}
		return totalPrice;
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
