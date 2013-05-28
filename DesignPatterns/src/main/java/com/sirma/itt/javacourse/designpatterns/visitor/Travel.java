package com.sirma.itt.javacourse.designpatterns.visitor;

/**
 * This is the visitor for the different vihecles that will get the travel times with them.
 * 
 * @author gdimitrov
 */
public class Travel implements Visitor {

	private double travelTime;

	/**
	 * Sets the travel time to 0.
	 */
	public Travel() {
		travelTime = 0;
	}

	@Override
	public void visit(Bike bike) {
		int distance = bike.getDistance();
		int speed = bike.getSpeed();
		if (distance > 100) {
			speed = speed - (1 / 3) * speed;
		}
		travelTime += ((double) distance) / speed;
	}

	@Override
	public void visit(Car car) {
		int distance = car.getDistance();
		int speed = car.getSpeed();
		if (distance > 300) {
			travelTime += 0.25;
		}
		travelTime += ((double) distance) / speed;
	}

	/**
	 * Getter method for travelTime.
	 * 
	 * @return the travelTime
	 */
	public double getTravelTime() {
		return travelTime;
	}

}
