package com.sirma.itt.javacourse.designpatterns.visitor;

import java.util.ArrayList;

/**
 * A traveler travels a route.
 * 
 * @author gdimitrov
 */
public class Traveler {

	/**
	 * Calculates the travel time with the given vihecles.
	 * 
	 * @param vihecles
	 *            - the vihecles which will be used to travel the route.
	 * @return the travel time.
	 */
	public double calculateTravelTime(ArrayList<Visitable> vihecles) {
		Travel visitor = new Travel();
		for (Visitable vihecle : vihecles) {
			vihecle.accept(visitor);
		}
		return visitor.getTravelTime();
	}
}
