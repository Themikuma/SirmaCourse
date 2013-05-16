package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Imitates throwing two dice and recording statistics.
 * 
 * @author gdimitrov
 */
public class Dice {
	private int currentRoll;
	private HashMap<String, ArrayList<Integer>> occurances;

	/**
	 * Getter method for occurances.
	 * 
	 * @return the occurances
	 */
	public HashMap<String, ArrayList<Integer>> getOccurances() {
		return occurances;
	}

	private int sides;

	/**
	 * Creates 21 new arrays for all the positionally irrelevant combinations of two six sided dice.
	 * 
	 * @param sides
	 *            - how many sides the dice has.
	 */
	public Dice(int sides) {
		occurances = new HashMap<>();
		currentRoll = 1;
		this.sides = sides;
		for (int i = 1; i < sides + 1; i++) {
			for (int j = 1; j < sides + 1; j++) {
				occurances.put(i + "," + j, new ArrayList<Integer>());
			}
		}
	}

	/**
	 * Rolls the dice and adds the current roll to one of the lists that represent the rolls.
	 */
	public void rollDice() {
		Random r = new Random();
		int firstDice = r.nextInt(sides) + 1;
		int secondDice = r.nextInt(sides) + 1;
		ArrayList<Integer> list = new ArrayList<>();
		list = occurances.get(firstDice + "," + secondDice);
		list.add(currentRoll);
		occurances.remove(firstDice + "," + secondDice);
		occurances.put(firstDice + "," + secondDice, list);
		currentRoll++;
	}

	/**
	 * Shows all the results for the rolls of the dice.
	 * 
	 * @return returns the set of combinations with the rolls on which they occurred.
	 */
	public String showResults() {
		StringBuilder result = new StringBuilder();
		for (String key : occurances.keySet()) {
			result.append(key + "=" + occurances.get(key) + "\n");
		}
		return result.toString();
	}
}
