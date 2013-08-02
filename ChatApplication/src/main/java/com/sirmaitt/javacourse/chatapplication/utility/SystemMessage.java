package com.sirmaitt.javacourse.chatapplication.utility;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Gets internatiolized system messages and UI captions for the chat application.
 * 
 * @author gdimitrov
 */
public final class SystemMessage {

	/**
	 * Private constructor for utility classes.
	 */
	private SystemMessage() {
	}

	private static Locale currentLocale = Locale.ENGLISH;

	/**
	 * Sets the locale to be used for getting the messages.
	 * 
	 * @param locale
	 *            the new locale.
	 */
	public static void setLocale(Locale locale) {
		currentLocale = locale;
	}

	/**
	 * Gets a message from the resource bundle by using the key provided.
	 * 
	 * @param key
	 *            the key of the message.
	 * @param resourceName
	 *            the name of the resource file that contains the message.
	 * @return the internationalized message.
	 */
	public static String getMessage(String key, ResourceNames resourceName) {
		ResourceBundle bundle = ResourceBundle.getBundle(resourceName.toString(), currentLocale);
		return bundle.getString(key);
	}
}
