package com.sirma.itt.javacourse.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This is the class that reads user input from the console.
 * 
 * @author gdimitrov
 */
public class HangmanReaderImpl implements HangmanReader {

	public String startGame() {
		boolean incorrectWord = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = null;
		while (incorrectWord) {
			System.out.println("Enter the word to guess");
			try {
				word = br.readLine();
			} catch (Exception e) {
			}
			if (!word.matches("[a-zA-Z]*")) {
				System.out.println("This is not a word");
			} else {
				incorrectWord = false;
			}
		}
		return word.toLowerCase();
	}

	public char move() {
		char cbuf = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a letter from the word");
		try {
			cbuf = br.readLine().toLowerCase().charAt(0);
		} catch (Exception e) {
		}
		return cbuf;
	}

	public boolean endGame() {
		boolean newGame = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char cbuf = 0;

		while (true) {
			System.out.println("New game y/n");
			try {
				cbuf = br.readLine().toLowerCase().charAt(0);
			} catch (Exception e) {
			}
			if (cbuf == 'n') {
				newGame = false;
				break;
			} else if (cbuf == 'y') {
				newGame = true;
				break;
			}
		}
		return newGame;
	}
}
