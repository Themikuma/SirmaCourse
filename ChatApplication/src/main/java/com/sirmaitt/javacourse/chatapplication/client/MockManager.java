package com.sirmaitt.javacourse.chatapplication.client;

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
		result = "disconnect";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void displayUserList(String message) {
		result = "userList";
	}

	@Override
	public void displayErrorMessage(String message) {
		result = "error";
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
}
