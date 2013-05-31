/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.builder;

import java.util.Arrays;

/**
 * Creates a mail object by using the builder pattern.
 * 
 * @author Georgi
 */
public final class Mail {
	private String from;
	private String to;
	private String subject;
	private String content;
	private String cc;
	private String[] attachments;

	/**
	 * Private constructor for the builder.
	 */
	private Mail() {
	}

	/**
	 * Creates the mail object and sets who is it from.
	 * 
	 * @param from
	 *            the sender of the mail
	 * @return a mail object for further processing.
	 */
	public static Mail from(String from) {
		Mail mail = new Mail();
		mail.from = from;
		return mail;
	}

	/**
	 * Sets who should receive the mail.
	 * 
	 * @param to
	 *            the receiver.
	 * @return the mail for further processing.
	 */
	public Mail to(String to) {
		this.to = to;
		return this;
	}

	/**
	 * Adds the subject to the mail .
	 * 
	 * @param subject
	 *            the subject of the mail.
	 * @return the mail for further processing.
	 */
	public Mail subject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Adds the content to the mail.
	 * 
	 * @param content
	 *            the content of the mail.
	 * @return the mail for further processing.
	 */
	public Mail content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Adds CC to the mail.
	 * 
	 * @param cc
	 *            any mails that should get a CC.
	 * @return the mail for further processing.
	 */
	public Mail cc(String cc) {
		this.cc = cc;
		return this;
	}

	/**
	 * Adds attachments to the mail.
	 * 
	 * @param attachments
	 *            array of attachments.
	 * @return the finished mail.
	 */
	public Mail attachments(String... attachments) {
		this.attachments = new String[attachments.length];
		System.arraycopy(attachments, 0, this.attachments, 0, attachments.length);
		return this;
	}

	/**
	 * Sends the mail.
	 */
	public void sendMail() {
		System.out.println("from: " + from);
		System.out.println("to: " + to);
		System.out.println("subject: " + subject);
		System.out.println("content: " + content);
		System.out.println("CC: " + cc);
		System.out.println("attachments: " + Arrays.toString(attachments));
	}
}
