package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

/**
 * This class replaces text,following a pattern.
 * 
 * @author gdimitrov
 */
public final class ReplaceText {
	/**
	 * Private constructor for utility classes.
	 */
	private ReplaceText() {
	}

	/**
	 * Replaces text that is between <"x"> and <"/x"> with <"x/">.
	 * 
	 * @param text
	 *            the text to be replaced
	 * @return the replaced text
	 */
	public static String replace(String text) {
		String result = null;
		result = text.replaceAll("<x>[^<]*[^x]*[^>]*</x>", "<x/>");
		return result;
	}
}
