/**
 * 
 */
package com.sirmaitt.tasks1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author gdimitrov
 * 
 */
public class Hangman {

	private int wrongGuesses;
	private String word;
	private String guessed;
	private boolean newGame;

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// Hangman game = new Hangman();
	// game.startGame();
	//
	// }

	/**
	 * This method initializes a new game, by asking for a new word to be
	 * entered and setting the wrong guesses to 0
	 */
	public void startGame() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println("Enter the word to guess");
		try {
			word = br.readLine();
		} catch (Exception e) {
		}
		wrongGuesses = 0;
		newGame = false;
		guessed = word.replaceAll("[a-zA-Z]", "*");
		playGame();
		// System.out.println(word);
		// System.out.println(guessed);
	}

	private void playGame() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		char[] cbuf = new char[1];
		boolean found = false;
		StringBuilder builder = new StringBuilder();
		builder.append(guessed);
		int i;
		while ((wrongGuesses < 7) && guessed.contains("*")) {
			i = 0;
			System.out.println("Enter a letter from the word");
			try {
				cbuf[0] = br.readLine().charAt(0);
			} catch (Exception e) {
			}
			while (word.substring(i).indexOf(cbuf[0]) >= 0) {
				found = true;
				i += word.substring(i).indexOf(cbuf[0]);
				builder.setCharAt(i, cbuf[0]);
				i++;
				if (i == -1) {
					break;
				}
			}
			if (!found) {
				wrongGuesses++;
				System.out.println("You made a mistake, you have "
						+ (7 - wrongGuesses) + " mistakes remaining");
			} else {
				guessed = builder.toString();
				found = false;
				System.out.println(guessed);
			}
		}
		endGame();
	}

	private void endGame() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		char[] cbuf = new char[1];
		if (wrongGuesses == 7) {
			System.out.println("You died!");
		} else {
			System.out.println("You won!");
		}
		while (true) {
			System.out.println("New game y/n");
			try {
				cbuf[0] = br.readLine().charAt(0);
			} catch (Exception e) {
			}
			if (cbuf[0] == 'n') {
				newGame = false;
				break;
			} else if (cbuf[0] == 'y') {
				newGame = true;
				break;
			}
		}
		if (newGame) {
			startGame();
		}

	}
}
