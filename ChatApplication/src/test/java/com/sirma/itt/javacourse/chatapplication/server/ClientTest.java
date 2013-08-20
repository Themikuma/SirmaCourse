/**
 * 
 */
package com.sirma.itt.javacourse.chatapplication.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirmaitt.javacourse.chatapplication.client.Client;
import com.sirmaitt.javacourse.chatapplication.client.MockManager;
import com.sirmaitt.javacourse.chatapplication.utility.Messages;

/**
 * Tests the client's methods.
 * 
 * @author Georgi
 * 
 */
public class ClientTest {

	/**
	 * Tests the error response for a client.
	 */
	@Test
	public void testCheckResponseError() {
		MockManager manager = new MockManager();
		Client client = new Client(manager);
		client.checkResponse(Messages.ERROR.toString());
		assertEquals("error", manager.getResult());
	}

	/**
	 * Tests the message response for a client.
	 */
	@Test
	public void testCheckResponseMessage() {
		MockManager manager = new MockManager();
		Client client = new Client(manager);
		assertTrue(client.checkResponse("someMessage"));
	}
}
