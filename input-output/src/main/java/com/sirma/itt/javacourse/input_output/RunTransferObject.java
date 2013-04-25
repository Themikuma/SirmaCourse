package com.sirma.itt.javacourse.input_output;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Contains an entry point method for running the {@link TransferObject} class.
 * 
 * @author gdimitrov
 */
public final class RunTransferObject {
	/**
	 * Private constructor for utility classes.
	 */
	private RunTransferObject() {
	}

	/**
	 * Runs the {@link TransferObject} class.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */

	public static void main(String[] args) {
		byte[] bytes = new byte[50];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (i + 100);
		}
		BufferedInputStream br = new BufferedInputStream(new ByteArrayInputStream(bytes));
		// BufferedInputStream br = new BufferedInputStream(System.in);
		BufferedOutputStream outputStream = new BufferedOutputStream(System.out);
		TransferObject objectTransfer = new TransferObject(br, outputStream);
		System.out.println(objectTransfer.transfer(12, 6));
		try {
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
