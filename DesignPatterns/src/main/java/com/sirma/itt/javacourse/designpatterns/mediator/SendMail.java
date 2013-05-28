package com.sirma.itt.javacourse.designpatterns.mediator;

/**
 * Manages sending messages to the mailing list.
 * 
 * @author gdimitrov
 */
public class SendMail {
	private Mediator mediator;

	/**
	 * Creates an instance of the mediator.
	 */
	public SendMail() {
		mediator = new Mediator();
	}

	/**
	 * Calls the mediator's send mail method and displays how many people recieved the email.
	 */
	public void sendEmail() {
		int sent = mediator.sendMail("Here is an email");
		System.out.println(sent);
	}

}
