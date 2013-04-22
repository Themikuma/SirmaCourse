package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import java.util.regex.Pattern;

/**
 * Hides the numbers of valid Bulgarian IBANs.
 * 
 * @author gdimitrov
 */
public final class HideIBAN {
	private static final Pattern VALID_PATTERN = Pattern
			.compile("<iban>BG[0-9]{2} [a-zA-Z]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}</iban>");

	/**
	 * Private constructor for utility classes.
	 */
	private HideIBAN() {
	}

	/**
	 * Checks whether an IBAN is a valid Bulgarian IBAN.
	 * 
	 * @param iban
	 *            the IBAN to be validated.
	 * @return true if the IBAN is valid.
	 */
	public static boolean isValid(String iban) {
		return VALID_PATTERN.matcher(iban).matches();
	}

	/**
	 * Hides a valid Bulgarian IBAN.
	 * 
	 * @param iban
	 *            the IBAN to hide
	 * @return the hidden IBAN
	 */
	public static String hideIBAN(String iban) {
		String result = null;
		if (isValid(iban)) {
			result = iban.replaceAll("BG[0-9]{2} [a-zA-Z]{4} [0-9]{4} [0-9]{4} [0-9]{4} ", "****");
		} else {
			result = iban;
		}
		return result;
	}
}
