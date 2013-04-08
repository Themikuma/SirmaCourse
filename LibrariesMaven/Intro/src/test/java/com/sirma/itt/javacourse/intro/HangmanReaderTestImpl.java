package com.sirma.itt.javacourse.intro;

/**
 * This is a class that simulates user input. It allows for 3 games with an expected result to be
 * played.
 * 
 * @author gdimitrov
 */
public class HangmanReaderTestImpl implements HangmanReader {

	private char[] guesses = { 'g', 'u', 'a', 'e', 'r', 't', 's', 'z', 'x', 'v', 'c', 'q' };
	private int nextItem = 0;
	private String[] words = { "guess", "troll", "wrong" };
	private int nextWord = 0;

	public String startGame() {
		String result = words[nextWord];
		nextWord++;
		nextItem = 0;
		return result;
	}

	public char move() {
		char result = guesses[nextItem];
		nextItem++;
		return result;
	}

	public boolean endGame() {
		return true;
	}

}
