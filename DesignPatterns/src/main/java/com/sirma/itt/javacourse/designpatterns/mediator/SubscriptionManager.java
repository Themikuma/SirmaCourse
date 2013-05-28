package com.sirma.itt.javacourse.designpatterns.mediator;

/**
 * This class manages subscribing people to the mailing list.
 * 
 * @author gdimitrov
 */
public class SubscriptionManager {
	private Mediator mediator;

	/**
	 * Creates an instance of the mediator.
	 */
	public SubscriptionManager() {
		mediator = new Mediator();
	}

	/**
	 * Subscribes the user to the mailing list.
	 * 
	 * @param email
	 *            the email to be added.
	 */
	public void subscribe(String email) {
		mediator.subscribe(email);
	}

	/**
	 * Removes the user from the mailing list.
	 * 
	 * @param email
	 *            the email to be removed.
	 */
	public void unsubscribe(String email) {
	}

}
