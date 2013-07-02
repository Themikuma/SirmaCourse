/**
 * 
 */
package com.sirma.itt.javacourse.neterowkingandgui.tests;

import static org.junit.Assert.*;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.networkingandgui.clientinfo.Client;
import com.sirma.itt.javacourse.networkingandgui.clientinfo.Server;

/**
 * @author Georgi
 *
 */
public class ClientInfoTest {
	
	/**
	 * Test the client information task with a server and two clients.
	 */
	@Test
	public void testClientInfo(){
		JTextArea client1Log=new JTextArea();
		JTextArea client2Log=new JTextArea();
		Server server=new Server(7002, new JTextArea());
		Thread serverThread=new Thread(server);
		serverThread.start();
		Client client = new Client(client1Log);
		Thread clientThread = new Thread(client);
		clientThread.start();
		try {
			//Give the first client a time lead so it's certain that he is the first one.
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Client client2 = new Client(client2Log);
		Thread clientThread2 = new Thread(client2);
		clientThread2.start();
		try {
			//Wait for the clients to successfully connect to the server.
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Searching for an open port "+System.lineSeparator()+"Connected"
		+System.lineSeparator()+"You're client number 1"+System.lineSeparator()+
		"Client number 2 joined our ranks"+System.lineSeparator(),client1Log.getText());
		
	}
	
}
