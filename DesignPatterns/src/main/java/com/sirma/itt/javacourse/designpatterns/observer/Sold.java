package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;

/**
 * The class that monitors the sold products.
 * 
 * @author gdimitrov
 */
public class Sold {
	private ArrayList<Object> soldProducts;

	/**
	 * Instantiates the sold products list.
	 */
	public Sold() {
		soldProducts = new ArrayList<Object>();
	}

	/**
	 * Adds a sold product to the sold products list.
	 * 
	 * @param product
	 *            the product that was sold.
	 */
	public void addSold(Object product) {
		soldProducts.add(product);
	}

}
