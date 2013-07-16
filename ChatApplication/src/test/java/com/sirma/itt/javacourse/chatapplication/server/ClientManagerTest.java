package com.sirma.itt.javacourse.chatapplication.server;

import static org.junit.Assert.assertEquals;

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
	 * Tests if the client manager accepts two clients with the same nickname.
	 */
	@Test
	public void testAddClientsWithSameNicknames() {
		ClientManager manager = new ClientManager();
		Client client1 = new Client("clients", System.out);
		Client client2 = new Client("clients", new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}
		});
		manager.addClient(client1);
		manager.addClient(client2);
		Set<Client> clients = manager.getClients();
		assertEquals(2, clients.size());
	}

	/**
	 * Tests the client manager by trying to add some clients with invalid characters in their
	 * names.
	 */
	@Test
	public void testAddClientsWithInvalidNames() {
		ClientManager manager = new ClientManager();
		Client client1 = new Client("client[s", System.out);
		Client client2 = new Client("clien[]ts", new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}
		});
		manager.addClient(client1);
		manager.addClient(client2);
		Set<Client> clients = manager.getClients();
		assertEquals(1, clients.size());
	}

	/**
	 * Tests the client manager by adding different clients with the same output stream, but
	 * different nicknames.
	 */
	@Test
	public void testAddClientsWithDifferentNames() {
		ClientManager manager = new ClientManager();
		Client client1 = new Client("client1", System.out);
		Client client2 = new Client("clientd2", System.out);
		Client client3 = new Client("clientr3", System.out);
		Client client4 = new Client("client4", System.out);
		Client client5 = new Client("client5", System.out);
		manager.addClient(client1);
		manager.addClient(client2);
		manager.addClient(client3);
		manager.addClient(client4);
		manager.addClient(client5);
		Set<Client> clients = manager.getClients();
		assertEquals(6, clients.size());

	}
}
