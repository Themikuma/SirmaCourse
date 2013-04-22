package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

/**
 * This class is used to validate emails.
 * 
 * @author gdimitrov
 */
public final class EmailValidator {
	/**
	 * Private constructor for utility classes.
	 */
	private EmailValidator() {
	}

	/**
	 * Determines whether an email is valid or not.
	 * 
	 * @param email
	 *            the email to be validated.
	 * @return true if the email is valid
	 */
	public static boolean isValid(String email) {
		if (email.matches("[a-zA-Z][\\w|.|-]*[@][\\w|.|-]*")) {
			return true;
		}
		return false;
	}

}
