package test.java;

import static org.junit.Assert.assertTrue;

import main.java.Hangman;
import main.java.HangmanReaderTestImpl;

import org.junit.Test;


/**
 * Tests for the hangman game
 * 
 * @author gdimitrov
 */
public class HangmanTests {
	/**
	 * This test plays three games, the first should be won and the other two should be lost
	 */
	@Test
	public void testHangman() {
		Hangman provider = new Hangman(new HangmanReaderTestImpl());
		assertTrue(provider.playGame());
		assertTrue(!provider.playGame());
		assertTrue(!provider.playGame());
	}
}
