package com.sirma.itt.javacourse.designpatterns.strategy;

/**
 * This strategy has a private array of {@link String} that is printed to the console.
 * 
 * @author gdimitrov
 */
public class ConcreteStrategyB implements Strategy {

	private String[] lines = { "THIS", "IS", "SPARTAAA" };

	@Override
	public void execute() {
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
