package com.sirma.itt.javacourse.intro;

/**
 * Runs the hangman game.
 * 
 * @author gdimitrov
 */
public final class RunHangman {
	/**
	 * Private constructor for a utility class.
	 */
	private RunHangman() {

	}

	/**
	 * This is the hangman game. It allows you to enter a word to guess and then take guesses until
	 * you guess the word or seven mistakes are made.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		Hangman game = new Hangman(new HangmanReaderImpl());
		while (game.isNewGame()) {
			game.playGame();
		}
	}
}
