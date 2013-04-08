package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for the hangman game
 * 
 * @author gdimitrov
 */
public class HangmanTest {
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
