package com.sirma.itt.javacourse.designpatterns.state;

/**
 * Makes a beer case behave in different ways when it has beers and when it hasn't.
 * 
 * @author gdimitrov
 */
public class BeerCase implements BeerDrinking {
	private int beers;
	private BeerDrinking beerDrinking;

	/**
	 * Creates a beer case and gives it a number of beers.
	 * 
	 * @param numberOfBeers
	 *            how many beers does the case have.
	 */
	public BeerCase(int numberOfBeers) {
		beers = numberOfBeers;
		if (beers > 0) {
			beerDrinking = new FullCase();
		} else {
			beerDrinking = new EmptyCase();
		}
	}

	@Override
	public String drinkABeer() {
		String result = beerDrinking.drinkABeer();
		beers--;
		if (beers == 0) {
			beerDrinking = new EmptyCase();
		}
		return result;
	}

}
