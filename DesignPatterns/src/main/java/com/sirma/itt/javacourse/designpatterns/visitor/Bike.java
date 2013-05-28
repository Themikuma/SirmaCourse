package com.sirma.itt.javacourse.designpatterns.visitor;

/**
 * Bikes accept a visitor to check how fast they will travel a given distance.
 * 
 * @author gdimitrov
 */
public class Bike implements Visitable {

	private int speed;
	private int distance;

	/**
	 * Creates a bike object and gives it an average speed.
	 * 
	 * @param speed
	 *            the speed of the bike.
	 * @param distance
	 *            the distance to travel.
	 */
	public Bike(int speed, int distance) {
		this.distance = distance;
		this.speed = speed;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
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
