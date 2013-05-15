package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Imitates throwing two dice and recording statistics.
 * 
 * @author gdimitrov
 */
public class Dice {
	private List<ArrayList<Integer>> occurances;
	private int currentRoll;

	/**
	 * Creates 21 new arrays for all the positionally irrelevant combinations of two six sided dice.
	 */
	public Dice() {
		occurances = new ArrayList<ArrayList<Integer>>();
		currentRoll = 1;
		for (int i = 0; i < 21; i++) {
			occurances.add(new ArrayList<Integer>());
		}
	}

	/**
	 * Gets the position of the combination of dice. The combinations start at 1,1 and end with 6,6
	 * and are positionally irrelevant.
	 * 
	 * @param firstDice
	 *            the roll of the first dice
	 * @param secondDice
	 *            the roll of the second dice
	 * @return the position in which to insert the current roll.
	 */
	private int getPosition(int firstDice, int secondDice) {
		int actualFirstDice = 0;
		int actualSecondDice = 0;
		if (firstDice > secondDice) {
			actualFirstDice = secondDice;
			actualSecondDice = firstDice;
		} else {
			actualFirstDice = firstDice;
			actualSecondDice = secondDice;
		}
		switch (actualFirstDice) {
			case 1:
				switch (actualSecondDice) {
					case 1:
						return 0;
					case 2:
						return 1;
					case 3:
						return 2;
					case 4:
						return 3;
					case 5:
						return 4;
					default:
						return 5;
				}
			case 2:
				switch (actualSecondDice) {
					case 2:
						return 6;
					case 3:
						return 7;
					case 4:
						return 8;
					case 5:
						return 9;
					default:
						return 10;
				}
			case 3:
				switch (actualSecondDice) {
					case 3:
						return 11;
					case 4:
						return 12;
					case 5:
						return 13;
					default:
						return 14;
				}
			case 4:
				switch (actualSecondDice) {
					case 4:
						return 15;
					case 5:
						return 16;
					default:
						return 17;
				}
			case 5:
				switch (actualSecondDice) {
					case 5:
						return 18;
					default:
						return 19;
				}
			default:
				return 20;
		}
	}

	/**
	 * Rolls the dice and adds the current roll to one of the lists that represent the rolls.
	 */
	public void rollDice() {
		Random r = new Random();
		int firstDice = r.nextInt(6) + 1;
		int secondDice = r.nextInt(6) + 1;
		int position = getPosition(firstDice, secondDice);
		occurances.get(position).add(currentRoll);
		currentRoll++;
	}

	/**
	 * Finds the occurrences of the given combination of dice.
	 * 
	 * @param firstDice
	 *            the first dice to check.
	 * @param secondDice
	 *            the second dice to check.
	 * @return a string containing the rolls on which the combination occurred.
	 */
	public String showResults(int firstDice, int secondDice) {
		int position = getPosition(firstDice, secondDice);
		return occurances.get(position).toString();
	}
}
