package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

/**
 * Hides the numbers of valid Bulgarian IBANs.
 * 
 * @author gdimitrov
 */
public final class HideIBAN {
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
		if (iban.matches("<iban>BG[0-9]{2} [a-zA-Z]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}</iban>")) {
			return true;
		}
		return false;
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
