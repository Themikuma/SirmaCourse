package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * Runs a program that uses an object list.
 * 
 * @author gdimitrov
 */
public final class RunObjectList {

	private static ObjectList list;

	/**
	 * Private constructor for a utility class.
	 */
	private RunObjectList() {
	}

	/**
	 * Uses the object list to add different objects.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		list = new ObjectList(3, 3);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				list.remove();
				list.remove();
				list.remove();
				list.remove();
				list.remove();
				try {
					Thread.sleep(2900);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.remove();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
				list.addElement(new Object());
			}
		});

		t1.start();
		t2.start();
		while (t1.isAlive() || t2.isAlive()) {
		}
		t1.interrupt();
		t2.interrupt();
		list.printAllElements();
	}
}
