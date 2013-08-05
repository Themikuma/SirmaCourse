package com.sirmaitt.javacourse.chatapplication.client;

import java.util.Locale;
import java.util.ResourceBundle;

import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Returns the internationalized UI captions for the clients.
 * 
 * @author gdimitrov
 */
public final class UICaptions {
	/**
	 * Private constructor for utility classes.
	 */
	private UICaptions() {
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
	 * Gets a UI caption from the resource bundle using the key provided.
	 * 
	 * @param key
	 *            the key of the message.
	 * @param resourceName
	 *            the name of the resource file that contains the message.
	 * @return the internationalized caption.
	 */
	public static String getMessage(String key, ResourceNames resourceName) {
		ResourceBundle bundle = ResourceBundle.getBundle(resourceName.toString(), currentLocale);
		return bundle.getString(key);
	}

}
