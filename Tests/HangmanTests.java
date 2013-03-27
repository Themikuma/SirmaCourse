package com.sirmaitt.taks1tests;

import org.junit.Test;
import org.mockito.Mockito;

import com.sirmaitt.tasks1.Hangman;

public class HangmanTests {
	@Test
	public void testHangmanWin() {
		Hangman provider = new Hangman();
		InputAsker asker = Mockito.mock(InputAsker.class);
		Mockito.when(asker.ask("Enter the word to guess\n")).thenReturn("top");
		provider.startGame();
	}
}
