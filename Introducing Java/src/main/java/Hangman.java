/**
 * 
 */
package main.java;

/**
 * This class implements the Hangman game with a console input/output.
 * 
 * @author gdimitrov
 */
public class Hangman {

	private int wrongGuesses;
	private String word;
	private String guessed;
	private boolean newGame;
	private HangmanReader hangmanReader;

	public Hangman(HangmanReader hangmanReader) {
		this.hangmanReader = hangmanReader;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hangman game = new Hangman(new HangmanReaderImpl());
		game.newGame = true;
		while (game.newGame) {
			game.playGame();
		}

	}

	/**
	 * This method initializes a new game
	 */
	private void initGame() {
		word = hangmanReader.startGame();
		wrongGuesses = 0;
		guessed = word.replaceAll("[a-zA-Z]", "*");
		// System.out.println(word);
		System.out.println(guessed);
	}

	/**
	 * This method is the one that starts the game.
	 * 
	 * @return Returns if the player has won or lost the game
	 */
	public boolean playGame() {
		char cbuf = 0;
		int moves = 0;
		boolean win = false;
		boolean found = false;
		StringBuilder builder = new StringBuilder();
		initGame();
		builder.append(guessed);
		int i;
		while ((wrongGuesses < 7) && guessed.contains("*")) {
			i = 0;
			cbuf = hangmanReader.move();
			moves++;
			while (word.substring(i).indexOf(cbuf) >= 0) {
				found = true;
				i += word.substring(i).indexOf(cbuf);
				builder.setCharAt(i, cbuf);
				i++;
				if (i == -1) {
					break;
				}
			}
			if (!found) {
				wrongGuesses++;
				System.out.println("You made a mistake, you have " + (7 - wrongGuesses)
						+ " mistakes remaining");
			} else {
				guessed = builder.toString();
				found = false;
				System.out.println(guessed);
			}
		}
		if (wrongGuesses == 7) {
			System.out.println("You died in " + moves + " moves!");
			win = false;
		} else {
			System.out.println("You won in " + moves + " moves!");
			win = true;
		}
		if (hangmanReader.endGame()) {
			this.newGame = true;
		} else {
			this.newGame = false;
		}
		return win;
	}
}
