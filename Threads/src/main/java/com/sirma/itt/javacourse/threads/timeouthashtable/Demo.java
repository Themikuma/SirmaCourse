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
		TimeoutHashtable table = new TimeoutHashtable(10, 1000);
		Thread t1 = new Thread(table);
		t1.start();
		table.put("3", "tri");
		table.put("one", "oneone");
		Thread.sleep(500);
		table.put("two", "twotwo");
		table.remove("one");
		// table.get("3");
		Thread.sleep(700);
		table.get("two");
		table.stop();
		Object result = table.get("3");
		System.out.println(result);
	}

}
