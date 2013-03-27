package com.sirmaitt.taks1tests;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputAsker {
	private final Scanner scanner;
	private final PrintStream out;

	public InputAsker(InputStream in, PrintStream out) {
		scanner = new Scanner(in);
		this.out = out;
	}

	public String ask(String message) {
		out.println(message);
		return scanner.nextLine();
	}
}