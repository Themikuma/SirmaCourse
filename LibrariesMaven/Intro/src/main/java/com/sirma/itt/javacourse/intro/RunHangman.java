package com.sirma.itt.javacourse.intro;


/**
 * Runs the hangman game
 * 
 * @author gdimitrov
 */
public class RunHangman {

	public static void main(String[] args) {
		Hangman game = new Hangman(new HangmanReaderImpl());
		while (game.isNewGame()) {
			game.playGame();
		}
	}
}
