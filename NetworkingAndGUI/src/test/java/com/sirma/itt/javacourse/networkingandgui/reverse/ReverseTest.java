package com.sirma.itt.javacourse.networkingandgui.reverse;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Test;

/**
 * Tests the message reverse task.
 * 
 * @author gdimitrov
 */
public class ReverseTest {

	/**
	 * Test the reverse text task by connecting only one client to the server and checking the
	 * reversed message.
	 * 
	 * @throws InterruptedException
	 *             when a thread is interrupted
	 */
	@Test
	public void testReverseWithOneClient() throws InterruptedException {
		Server handler = new Server(7000, new JTextArea());
		Thread handlerThread = new Thread(handler);
		handlerThread.start();
		// Give the server time to start up
		Thread.sleep(100);
		Client client1 = new Client(new JTextField());
		Thread clientThread = new Thread(client1);
		clientThread.start();
		// Give the client time to connect.
		Thread.sleep(1000);
		StringBuilder message = new StringBuilder("Hello world!");
		client1.sendMessage(message.toString());
		// Wait for the message to be sent and recieved.
		Thread.sleep(100);
		assertEquals(message.reverse().toString(), client1.getServerResponse());
		handler.stop();
	}
}
