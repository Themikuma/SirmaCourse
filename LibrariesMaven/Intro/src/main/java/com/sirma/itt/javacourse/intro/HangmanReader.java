package com.sirma.itt.javacourse.intro;

/**
 * The interface of the console reader for the Hangman class.
 * 
 * @author gdimitrov
 */
public interface HangmanReader {
	/**
	 * This method reads a word from the console.
	 * 
	 * @return - the word that is going to be guessed
	 */
	String startGame();

	/**
	 * This method reads a single letter from the console.
	 * 
	 * @return - the letter that was entered
	 */
	char move();

	/**
	 * This method is used to decide if the user wants to quit playing the game.
	 * 
	 * @return - True if the game will go on, false if it's going to stop
	 */
	boolean endGame();

}
