/**
 * 
 */
package com.sirma.itt.javacourse.chatapplication.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirmaitt.javacourse.chatapplication.client.Client;
import com.sirmaitt.javacourse.chatapplication.client.ClientResources;
import com.sirmaitt.javacourse.chatapplication.client.MockManager;
import com.sirmaitt.javacourse.chatapplication.utility.Messages;
import com.sirmaitt.javacourse.chatapplication.utility.ResourceNames;

/**
 * Tests the client's methods.
 * 
 * @author Georgi
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
		assertEquals(ClientResources.getMessage("nickname_taken", ResourceNames.Errors),
				manager.getResult());
	}

	/**
	 * Tests the connected response for a client.
	 */
	@Test
	public void testCheckResponseConnected() {
		MockManager manager = new MockManager();
		Client client = new Client(manager);
		client.checkResponse(Messages.CONNECTED_.toString());
		assertEquals(ClientResources.getMessage("you_connected", ResourceNames.Messages),
				manager.getResult());
	}

	/**
	 * Tests the connected response for a client.
	 */
	@Test
	public void testCheckResponseDisconnected() {
		MockManager manager = new MockManager();
		Client client = new Client(manager);
		client.checkResponse(Messages.DISCONNECTED.toString());
		assertEquals(ClientResources.getMessage("you_disconnected", ResourceNames.Messages),
				manager.getResult());
	}

	/**
	 * Tests the list response for a client.
	 */
	@Test
	public void testCheckResponseList() {
		MockManager manager = new MockManager();
		Client client = new Client(manager);
		client.checkResponse(Messages.LIST.toString());
		assertEquals(Messages.LIST.toString(), manager.getResult());
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
