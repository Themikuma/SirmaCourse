package com.sirma.itt.javacourse.designpatterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This strategy reads user input from the console.
 * 
 * @author gdimitrov
 */
public class ConcreteStrategyA implements Strategy {

	@Override
	public void execute() {
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			line = br.readLine();
			System.out.println(line);
			line = br.readLine();
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
