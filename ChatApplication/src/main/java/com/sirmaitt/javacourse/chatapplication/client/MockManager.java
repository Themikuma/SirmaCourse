package com.sirmaitt.javacourse.chatapplication.client;

import com.sirmaitt.javacourse.chatapplication.utility.Messages;

/**
 * @author gdimitrov
 */
public class MockManager implements Manager {
	private String result;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void displayMessage(String message) {
		result = message;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void displayUserList(String message) {
		result = Messages.LIST.toString();
	}

	@Override
	public void displayErrorMessage(String message) {
		result = message;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
}
