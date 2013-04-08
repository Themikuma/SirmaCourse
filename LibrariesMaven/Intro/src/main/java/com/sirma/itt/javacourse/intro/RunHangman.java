package com.sirma.itt.javacourse.intro;

import com.sirma.itt.javacourse.intro.Hangman;
import com.sirma.itt.javacourse.intro.HangmanReaderImpl;

public class RunHangman {

	public static void main(String[] args) {
		Hangman game = new Hangman(new HangmanReaderImpl());
		while (game.isNewGame()) {
			game.playGame();
		}
	}
}
