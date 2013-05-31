package com.sirma.itt.javacourse.designpatterns.proxy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A client that uses {@link BigObjectsProxy} to access {@link BigObjects}.
 * 
 * @author gdimitrov
 */
public final class ProxyClient {

	/**
	 * Private constructor for utility classes.
	 */
	private ProxyClient() {
	}

	/**
	 * @param args
	 *            - array of command-line arguments passed by the console.
	 */
	public static void main(String[] args) {
		Queue<ProxyPattern> commands = new LinkedList<ProxyPattern>();
		commands.add(new Tiny());
		commands.add(new Tiny());
		commands.add(new BigObjectsProxy());
		// In the case above if we had used the actual Proxy class, the size of the commands queue
		// would've been a lot greater.
	}
}
