package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests the Dice class.
 * 
 * @author gdimitrov
 */
public class TestDice {

	/**
	 * Tests the roll dice method by invoking it 3000 times and checking if all of the combinations
	 * have occurred at least once.
	 */
	@Test
	public void testRollDice() {
		Dice roller = new Dice();
		for (int i = 0; i < 3000; i++) {
			roller.rollDice();
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				assertFalse("[]".equals(roller.showResults(i, j)));
				assertFalse("[]".equals(roller.showResults(j, i)));
			}
		}
	}
}
