package com.sirmaitt.tasks1;

/**
 * The interface of the console reader for the Hangman class
 * 
 * @author gdimitrov
 */
public interface HangmanReader {
	/**
	 * This method reads a word from the console
	 * 
	 * @return - Returns the word that is going to be guessed
	 */
	public String startGame();

	public char move();

	/**
	 * This function is used to decide if the user wants to quit playing the game
	 * 
	 * @return - True if the game will go on, false if it's going to stop
	 */
	public boolean endGame();

}
