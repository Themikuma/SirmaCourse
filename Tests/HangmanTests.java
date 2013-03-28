package com.sirmaitt.taks1tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import com.sirmaitt.tasks1.Hangman;
import com.sirmaitt.tasks1.HangmanReader;

public class HangmanTests {
	@Test
	public void testHangmanWin() {
		Hangman provider = new Hangman();
		HangmanReader reader = Mockito.mock(HangmanReader.class);

		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('e');
		Mockito.when(reader.move(1, 4)).thenReturn('u');
		Mockito.when(reader.endGame(1)).thenReturn(false);
		assertTrue(provider.playGame(reader));
	}

	@Test
	public void testHangmanLoss() {
		Hangman provider = new Hangman();
		HangmanReader reader = Mockito.mock(HangmanReader.class);

		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('r');
		Mockito.when(reader.move(2, 3)).thenReturn('y');
		Mockito.when(reader.endGame(1)).thenReturn(true);
		assertTrue(!provider.playGame(reader));
	}

	@Test
	public void testHangmanLossWin() {
		Hangman provider = new Hangman();
		HangmanReader reader = Mockito.mock(HangmanReader.class);

		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('r');
		Mockito.when(reader.move(2, 3)).thenReturn('y');
		Mockito.when(reader.endGame(1)).thenReturn(true);
		assertTrue(!provider.playGame(reader));
		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('e');
		Mockito.when(reader.move(1, 4)).thenReturn('u');
		Mockito.when(reader.endGame(1)).thenReturn(false);
		assertTrue(provider.playGame(reader));

	}

	@Test
	public void testHangmanWinLoss() {
		Hangman provider = new Hangman();
		HangmanReader reader = Mockito.mock(HangmanReader.class);

		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('e');
		Mockito.when(reader.move(1, 4)).thenReturn('u');
		Mockito.when(reader.endGame(1)).thenReturn(true);

		Mockito.when(reader.startGame()).thenReturn("guess");
		Mockito.when(reader.move(0, 0)).thenReturn('g');
		Mockito.when(reader.move(0, 1)).thenReturn('s');
		Mockito.when(reader.move(0, 2)).thenReturn('a');
		Mockito.when(reader.move(1, 3)).thenReturn('r');
		Mockito.when(reader.move(2, 3)).thenReturn('y');
		Mockito.when(reader.endGame(1)).thenReturn(false);
		provider.playGame(reader);

	}
}
