/**
 * 
 */
package com.sirma.itt.javacourse.networkingandgui;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.networkingandgui.clientinfo.Client;
import com.sirma.itt.javacourse.networkingandgui.clientinfo.Server;

/**
 * Tests the client info task.
 * 
 * @author Georgi
 */
public class ClientInfoTest {

	/**
	 * Test the client information task with a server and two clients.
	 * 
	 * @throws InterruptedException
	 *             thrown when a thread is interrupted.
	 */
	@Test
	public void testClientInfo() throws InterruptedException {
		JTextArea client1Log = new JTextArea();
		JTextArea client2Log = new JTextArea();
		Server server = new Server(7000, new JTextArea());
		Thread serverThread = new Thread(server);
		serverThread.start();
		Client client = new Client(client1Log);
		Thread clientThread = new Thread(client);
		clientThread.start();
		// Give the first client a time lead so it's certain that he is the first one.
		Thread.sleep(100);
		Client client2 = new Client(client2Log);
		Thread clientThread2 = new Thread(client2);
		clientThread2.start();
		// Wait for the clients to connect to the server.
		Thread.sleep(1000);
		assertEquals(
				"Searching for an open port " + System.lineSeparator() + "Connected"
						+ System.lineSeparator() + "You're client number 1"
						+ System.lineSeparator() + "Client number 2 joined us"
						+ System.lineSeparator(), client1Log.getText());
		server.stop();
	}

}
