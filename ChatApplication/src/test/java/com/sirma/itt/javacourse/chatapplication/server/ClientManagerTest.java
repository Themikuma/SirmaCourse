package com.sirma.itt.javacourse.chatapplication.server;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.junit.Test;

import com.sirmaitt.javacourse.chatapplication.server.Client;
import com.sirmaitt.javacourse.chatapplication.server.ClientManager;

/**
 * Tests the client manager.
 * 
 * @author gdimitrov
 */
public class ClientManagerTest {

	/**
	 * Tests if the server manager accepts two clients with the same nickname.
	 */
	@Test
	public void testAddClientsWithSameNicknames() {
		ClientManager manager = new ClientManager();
		Client client1 = new Client("pesho", System.out);
		Client client2 = new Client("pesho", new OutputStream() {

			@Override
			public void write(int b) throws IOException {
				// TODO Auto-generated method stub

			}
		});
		manager.addClient(client1);
		manager.addClient(client2);
		Set<Client> clients = manager.getClients();
		for (Client client : clients) {
			System.out.println(client);
		}
	}
}
