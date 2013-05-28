package com.sirma.itt.javacourse.designpatterns.visitor;

/**
 * Cars accept a visitor to check how fast they will travel a given distance.
 * 
 * @author gdimitrov
 */
public class Car implements Visitable {
	private int speed;
	private int distance;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Creates a car object and gives it an average speed.
	 * 
	 * @param speed
	 *            the speed of the car.
	 * @param distance
	 *            the distance to travel.
	 */
	public Car(int speed, int distance) {
		this.distance = distance;
		this.speed = speed;
	}

	/**
	 * Getter method for speed.
	 * 
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Getter method for distance.
	 * 
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

}
