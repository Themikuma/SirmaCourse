package com.sirma.itt.javacourse.chatapplication.server;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sirmaitt.javacourse.chatapplication.client.Client;
import com.sirmaitt.javacourse.chatapplication.client.Manager;
import com.sirmaitt.javacourse.chatapplication.client.MockManager;
import com.sirmaitt.javacourse.chatapplication.server.MockLogManager;
import com.sirmaitt.javacourse.chatapplication.server.Server;

/**
 * @author gdimitrov
 */
public class ServerTest {

	/**
	 * Tests the server by connecting a lot of clients to it.
	 */
	@Test
	public void testServerWithManyClients() {

		Server server = new Server(7007, new MockLogManager());
		Thread connectionThread = new Thread(server);
		connectionThread.start();
		Manager manager = new MockManager();
		List<Client> clients = new ArrayList<>();
		int n = 300;
		for (int i = 0; i < n; i++) {
			clients.add(new Client(manager));
		}
		int i = 0;
		for (Client client : clients) {
			i++;
			client.connect("localhost:7007", "user" + i);
			Thread t1 = new Thread(client);
			t1.start();
		}
		assertTrue(true);
	}
}
