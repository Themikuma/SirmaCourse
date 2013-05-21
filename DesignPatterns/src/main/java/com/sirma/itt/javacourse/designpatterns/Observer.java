package com.sirma.itt.javacourse.designpatterns;

/**
 * The class that notifies the {@link Available} and {@link Sold} classes about any changes
 * concerning them.
 * 
 * @author gdimitrov
 */
public class Observer {

	private Available available;
	private Sold sold;

	/**
	 * Instantiate both the subscribers.
	 */
	public Observer() {
		sold = new Sold();
		available = new Available();

	}

	/**
	 * Marks a product to be sold. This calls the sell methods on both {@link Available} and
	 * {@link Sold}
	 * 
	 * @param product
	 *            the product to sell.
	 */
	public void sell(Object product) {
		sold.addSold(product);
		available.sellProduct(product);
	}

	/**
	 * Informs the subscriber that a new product was added.
	 * 
	 * @param product
	 *            the product that was added.
	 */
	public void addNewProduct(Object product) {
		available.addNewProduct(product);
	}
}
