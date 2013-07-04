/**
 * 
 */
package com.sirma.itt.javacourse.networkingandgui.clientserver;

import static org.junit.Assert.assertEquals;

import javax.swing.JTextArea;

import org.junit.Test;

/**
 * Test on the client-server task.
 * 
 * @author Georgi
 */
public class ClientServerTest {

	/**
	 * Tests the logging of the server.
	 */
	@Test
	public void testClientServer() {
		JTextArea log = new JTextArea();
		Server server = new Server(7001, log);
		server.start();
		Thread t1 = new Thread(server);
		t1.start();
		Client client = new Client();
		client.runClient();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Waiting for connection..." + System.lineSeparator()
				+ "/127.0.0.1 has succesfully connected on port 7001" + System.lineSeparator(),
				log.getText());
		server.stop();
	}

}
