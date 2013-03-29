package com.sirmaitt.taks1tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirmaitt.tasks1.Hangman;
import com.sirmaitt.tasks1.HangmanReaderTestImpl;

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
