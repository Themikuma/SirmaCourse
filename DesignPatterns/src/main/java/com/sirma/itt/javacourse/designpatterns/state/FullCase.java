package com.sirma.itt.javacourse.designpatterns.state;

/**
 * How the button behaves when it's not pressed.
 * 
 * @author gdimitrov
 */
public class FullCase implements BeerDrinking {

	@Override
	public String drinkABeer() {
		return "Here is beer. It's free!";
	}

}
