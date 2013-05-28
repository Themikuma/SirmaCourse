package com.sirma.itt.javacourse.designpatterns.visitor;

/**
 * The implementing classes are visitors for the visitable interface.
 * 
 * @author gdimitrov
 */
public interface Visitor {

	/**
	 * Visits a bike and gets the time needed to travel the distance.
	 * 
	 * @param bike
	 *            the instance of bike to visit.
	 */
	void visit(Bike bike);

	/**
	 * Visits a car and gets the time needed to travel the distance.
	 * 
	 * @param car
	 *            the instance of car to visit.
	 */
	void visit(Car car);
}
