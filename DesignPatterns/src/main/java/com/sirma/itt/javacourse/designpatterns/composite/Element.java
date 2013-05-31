/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.composite;

/**
 * The interface for all the elements, both leaves and composites.
 * 
 * @author Georgi
 */
public interface Element {

	/**
	 * Gets the value of all the products for the selected element.
	 * 
	 * @return the value of the products.
	 */
	int getTotalPrice();
}
