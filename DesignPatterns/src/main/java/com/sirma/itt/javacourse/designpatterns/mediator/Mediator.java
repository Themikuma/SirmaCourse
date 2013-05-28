package com.sirma.itt.javacourse.designpatterns.mediator;

/**
 * The mediator for the mailing list software.
 * 
 * @author gdimitrov
 */
public class Mediator {

	/**
	 * Subscribes the email to the mailing list.
	 * 
	 * @param email
	 *            the mail to be added.
	 */
	public void subscribe(String email) {
		// The actual implementation of subscribing a person to a mailing list goes here.
	}

	/**
	 * Unsubscribes the email from the mailing list.
	 * 
	 * @param email
	 *            the mail to be removed.
	 */
	public void unsubscribe(String email) {
		// The actual implementation of removing a person from the mailing list goes here.
	}

	/**
	 * Sends the email to the people subscribed on the mailing list.
	 * 
	 * @param text
	 *            the text of the email.
	 * @return the number of people that the email was sent to.
	 */
	public int sendMail(String text) {
		// Get the mailing list and send a mail to everyone.
		return 0;
	}
}
