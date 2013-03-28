/**
 * 
 */
package com.sirmaitt.tasks1;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hangman game = new Hangman();
		game.newGame = true;
		while (game.newGame) {
			game.playGame(new HangmanReader());
		}

	}

	/**
	 * This method initializes a new game, by asking for a new word to be
	 * entered and setting the wrong guesses to 0
	 */
	private void initGame(HangmanReader hangmanReader) {
		// TODO Auto-generated method stub
		word = hangmanReader.startGame();
		wrongGuesses = 0;
		guessed = word.replaceAll("[a-zA-Z]", "*");
		// System.out.println(word);
		System.out.println(guessed);
	}

	public boolean playGame(HangmanReader hangmanReader) {
		int rightGuesses = 0;
		char cbuf = 0;
		boolean win = false;
		boolean found = false;
		StringBuilder builder = new StringBuilder();
		initGame(hangmanReader);
		builder.append(guessed);
		int i;
		while ((wrongGuesses < 7) && guessed.contains("*")) {
			i = 0;
			cbuf = hangmanReader.move(wrongGuesses, rightGuesses);
			while (word.substring(i).indexOf(cbuf) >= 0) {
				found = true;
				rightGuesses++;
				i += word.substring(i).indexOf(cbuf);
				builder.setCharAt(i, cbuf);
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
		if (wrongGuesses == 7) {
			System.out.println("You died!");
			win = false;
		} else {
			System.out.println("You won!");
			win = true;
		}
		if (hangmanReader.endGame(wrongGuesses)) {
			this.newGame = true;
		} else {
			this.newGame = false;
		}
		return win;
	}
}
