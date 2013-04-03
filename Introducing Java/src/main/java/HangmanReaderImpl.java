/**
 * 
 */
package main.java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This is the class that reads user input from the console.
 * 
 * @author gdimitrov
 */
public class HangmanReaderImpl implements HangmanReader {

	@Override
	public String startGame() {
		InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String word = new String();
		System.out.println("Enter the word to guess");
		try {
			word = br.readLine();
		} catch (Exception e) {
		}
		return word.toLowerCase();
	}

	@Override
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

	@Override
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
