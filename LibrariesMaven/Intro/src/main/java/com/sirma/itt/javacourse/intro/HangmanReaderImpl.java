package com.sirma.itt.javacourse.intro;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This is the class that reads user input from the console.
 * 
 * @author gdimitrov
 */
public class HangmanReaderImpl implements HangmanReader {

	public String startGame() {
		boolean incorrectWord = true;
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String word = new String();
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
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println("Enter a letter from the word");
		try {
			cbuf = br.readLine().toLowerCase().charAt(0);
		} catch (Exception e) {
		}
		return cbuf;
	}

	public boolean endGame() {
		boolean newGame = false;
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		char[] cbuf = new char[1];

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
		return newGame;
	}
}
