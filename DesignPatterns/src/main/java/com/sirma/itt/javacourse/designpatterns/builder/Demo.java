/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.builder;

/**
 * Demo class for the builder pattern.
 * 
 * @author Georgi
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {
	}

	/**
	 * Entry point for the program.
	 * 
	 * @param args
	 *            array of command-line arguments given by the user.
	 */
	public static void main(String[] args) {
		String from = "Gosho";
		String to = "Pesho";
		String content = "I have finished my design pattern tasks";
		String subject = "design patterns";
		String cc = "mail@abv.bg";
		String[] attachments = { "File1", "File2", "File3" };
		Mail mail = Mail.from(from).to(to).subject(subject).content(content).cc(cc)
				.attachments(attachments);
		mail.sendMail();
	}
}
