package com.sirma.itt.javacourse.designpatterns.state;

/**
 * How the button behaves when it's presesd.
 * 
 * @author gdimitrov
 */
public class EmptyCase implements BeerDrinking {

	@Override
	public String drinkABeer() {
		return "No more beers left sorry";
	}
}
