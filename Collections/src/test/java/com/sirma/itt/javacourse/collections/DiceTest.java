package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests the Dice class.
 * 
 * @author gdimitrov
 */
public class DiceTest {

	/**
	 * Tests the roll dice method by checking if after rolling the dice one of the lists of
	 * combinations was populated.
	 */
	@Test
	public void testRollDice() {
		boolean found = false;
		Dice roller = new Dice(8);
		roller.rollDice();
		for (String key : roller.getOccurances().keySet()) {
			if (!roller.getOccurances().get(key).isEmpty()) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}

	/**
	 * Tests if the show results function returns the proper format of the list.
	 */
	@Test
	public void testShowResults() {
		Dice roller = new Dice(3);
		String result = roller.showResults();
		assertEquals("3,3=[]\n1,1=[]\n1,2=[]\n3,1=[]\n3,2=[]\n2,3=[]\n2,2=[]\n2,1=[]\n1,3=[]\n",
				result);
	}

}
