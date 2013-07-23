package com.sirmaitt.javacourse.chatapplication.utility;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author gdimitrov
 */
public class JTextFieldLimit extends PlainDocument {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 7043125880032492295L;
	private int limit;

	/**
	 * Sets the limit of the text field.
	 * 
	 * @param limit
	 *            the limit.
	 */
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}