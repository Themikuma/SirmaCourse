package com.sirma.itt.javacourse.input_output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Transfers an object from the input stream to the output stream.
 * 
 * @author gdimitrov
 */
public class TransferObject {

	/**
	 * Constructs a TransferObject using an instance of {@link InputStream} and {@link OutputStream}
	 * .
	 * 
	 * @param input
	 *            an object extending the {@link InputStream} abstract class
	 * @param output
	 *            an object extending the {@link OutputStream} abstract class
	 */
	public TransferObject(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	private InputStream input;
	private OutputStream output;

	/**
	 * Transfers bytes from the input stream to the output stream.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes to be transferred
	 * @param offset
	 *            the offset at which to start transfering.
	 * @return the number of transferred bytes.
	 */
	public int transfer(int numberOfBytes, int offset) {
		byte[] readBytes = new byte[numberOfBytes + offset];
		byte[] writeBytes;
		int transferred = 0;
		try {
			transferred = input.read(readBytes);
			if (transferred <= offset) {
				writeBytes = new byte[0];
				return 0;
			} else {
				transferred -= offset;
				writeBytes = new byte[transferred];
				System.arraycopy(readBytes, offset, writeBytes, 0, writeBytes.length);
			}
			output.write(writeBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transferred;
	}
}
