package com.sirma.itt.javacourse.threads.timeouthashtable;

/**
 * Demonstrates how a TimeoutHashTable works.
 * 
 * @author gdimitrov
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {

	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method by the user.
	 * @throws InterruptedException
	 *             if any thread has interrupted the current thread
	 */
	public static void main(String[] args) throws InterruptedException {
		TimeoutHashtable table = new TimeoutHashtable();
		Thread t1 = new Thread(table);
		table.put("one", "oneone");
		table.put("two", "twotwo");
		t1.start();
		Thread.sleep(500);
		Thread.sleep(700);
		table.stop();
		Object result = table.get("two");
		System.out.println(result);
	}

}
