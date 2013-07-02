package com.sirma.itt.javacourse.networkingandgui;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.networkingandgui.transmiter.Client;
import com.sirma.itt.javacourse.networkingandgui.transmiter.Server;

/**
 * Tests the transmiter task.
 * 
 * @author gdimitrov
 */
public class TransmitterTest {

	/**
	 * Subscribes three clients to the different broadcasts of the server and checks what messages
	 * they recieved.
	 * 
	 * @throws InterruptedException
	 *             when a thread is interrupted.
	 */
	@Test
	public void testTransmitter() throws InterruptedException {
		Server server = new Server(7000, new JTextArea());
		Client client = new Client(new JTextArea());
		Client client2 = new Client(new JTextArea());
		Client client3 = new Client(new JTextArea());
		Thread serverThread = new Thread(server);
		Thread client1Thread = new Thread(client);
		Thread client2Thread = new Thread(client2);
		Thread client3Thread = new Thread(client3);
		serverThread.start();
		client.setSubscriptions("C#");
		client2.setSubscriptions("java");
		client3.setSubscriptions("stuff");
		client1Thread.start();
		client2Thread.start();
		client3Thread.start();
		// Make sure all of the clients have connected to the server.
		Thread.sleep(1000);
		String offtopic = "This is offtopic stuff";
		server.sendMessage(offtopic);
		String messageToBoth = "This is a message about C# and java";
		server.sendMessage(messageToBoth);
		// Make sure all messages are sent.
		Thread.sleep(100);
		assertEquals(messageToBoth, client.getServerResponse());
		assertEquals(messageToBoth, client2.getServerResponse());
		assertEquals(offtopic, client3.getServerResponse());
	}
}
