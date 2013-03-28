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
public class HangmanReader {

	public String startGame() {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String word = new String();
		System.out.println("Enter the word to guess");
		try {
			word = br.readLine();
		} catch (Exception e) {
		}
		return word;
	}

	public boolean endGame(int wrongGuesses) {
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

	public char move(int wrongGuesses, int rightGuesses) {
		char cbuf = 0;
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println("Enter a letter from the word");
		try {
			cbuf = br.readLine().charAt(0);
		} catch (Exception e) {
		}
		return cbuf;
	}
}
