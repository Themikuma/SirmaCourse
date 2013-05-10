package com.sirma.itt.javacourse.input_output;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the TransferObject class.
 * 
 * @author gdimitrov
 */
public class TransferObjectTest {

	private byte[] bytes;
	private BufferedInputStream br;
	private ByteArrayOutputStream outputStream;
	private TransferObject objectTransfer;

	/**
	 * Setup for the tests.
	 */
	@Before
	public void setup() {
		bytes = new byte[50];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (i + 100);
		}
		br = new BufferedInputStream(new ByteArrayInputStream(bytes));
		outputStream = new ByteArrayOutputStream();
		objectTransfer = new TransferObject(br, outputStream);
	}

	/**
	 * Tests the transfer function by making the offset as big as the input.
	 */
	@Test
	public void testTransferWithEqualInputAndOffset() {
		int numberOfBytes = 120;
		int offset = 50;
		objectTransfer.transfer(numberOfBytes, offset);
		assertEquals(outputStream.size(), 0);
		assertTrue(isTransferValid(numberOfBytes, offset));
	}

	/**
	 * Tests the transfer function with a greater offset than an input.
	 */
	@Test
	public void testTransferWithGreaterOffsetThanInput() {
		int numberOfBytes = 120;
		int offset = 500;
		objectTransfer.transfer(numberOfBytes, offset);
		assertEquals(outputStream.size(), 0);
		assertTrue(isTransferValid(numberOfBytes, offset));
	}

	/**
	 * Tests the transfer function with more bytes required than provided.
	 */
	@Test
	public void testTransferWithMoreRequiredThanProvided() {
		int numberOfBytes = 120;
		int offset = 5;
		objectTransfer.transfer(numberOfBytes, offset);
		assertEquals(outputStream.size(), 45);
		assertTrue(isTransferValid(numberOfBytes, offset));
	}

	/**
	 * Tests the transfer function with more bytes provided than required.
	 */
	@Test
	public void testTransferWithMoreProvidedThanRequired() {
		int numberOfBytes = 12;
		int offset = 5;
		objectTransfer.transfer(numberOfBytes, offset);
		assertEquals(12, outputStream.size());
		assertTrue(isTransferValid(numberOfBytes, offset));
	}

	/**
	 * Checks whether the transfer transfered the same bytes as in the input.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes that were transferred
	 * @param offset
	 *            the offset
	 * @return true if the transfer was successful.
	 */
	private boolean isTransferValid(int numberOfBytes, int offset) {
		byte[] byteArray = outputStream.toByteArray();
		for (int i = 0; i < numberOfBytes; i++) {
			if (i >= byteArray.length) {
				break;
			}
			if (byteArray[i] != bytes[i + offset]) {
				return false;
			}
		}
		return true;
	}
}
