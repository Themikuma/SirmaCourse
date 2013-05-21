package com.sirma.itt.javacourse.designpatterns;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A client that uses {@link IntegerProxy} to access {@link Proxy}.
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
		Queue<ProxyPattern> commands = new ConcurrentLinkedQueue<ProxyPattern>();
		commands.add(new Tiny());
		commands.add(new Tiny());
		commands.add(new IntegerProxy());
		// In the case above if we had used the actual Proxy class, the size of the commands queue
		// would've been a lot greater.
	}
}
