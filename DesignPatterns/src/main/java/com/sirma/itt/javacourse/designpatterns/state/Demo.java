package com.sirma.itt.javacourse.designpatterns.state;

/**
 * @author gdimitrov
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed on by the user.
	 */
	public static void main(String[] args) {
		BeerCase beers = new BeerCase(4);
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
		System.out.println(beers.drinkABeer());
	}

}
