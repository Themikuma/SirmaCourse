package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * A list with a fixed length, that can take objects.
 * 
 * @author gdimitrov
 */
public class ObjectList {
	private Object[] list;
	private int currentObject;
	private long patience = 1000;
	private long startTime;

	/**
	 * Constructor that takes the number of elements the list will have.
	 * 
	 * @param numberOfElements
	 *            how many elements the list will have.
	 * @param patience
	 *            the amount of time to wait to add/remove an element in seconds.
	 */
	public ObjectList(int numberOfElements, int patience) {
		list = new Object[numberOfElements];
		currentObject = 0;
		this.patience *= patience;
	}

	/**
	 * Method to add an element to the list. If the list is full waits the time given in the
	 * constructor of the class. If elements were removed during the wait it adds the element,
	 * otherwise it times out.
	 * 
	 * @param obj
	 *            the element to add.
	 * @return true if the element was added.
	 */
	public synchronized boolean addElement(Object obj) {
		if (currentObject == list.length) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " is waiting to add an object to the array");
				startTime = System.currentTimeMillis();
				wait(patience);
				if (System.currentTimeMillis() - startTime == patience) {
					System.out.println(Thread.currentThread().getName() + " got tired of waiting");
					return false;
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		list[currentObject] = obj;
		currentObject++;
		System.out.println(Thread.currentThread().getName() + " added an object to the array");
		notifyAll();
		return true;
	}

	/**
	 * Remove the last element in the list. If the list doesn't contain any elements waits the time
	 * given in the constructor of the class. If elements are added it removes the most recently
	 * added one, otherwise it times out.
	 * 
	 * @return true if an element was removed
	 */
	public synchronized boolean remove() {
		if (currentObject == 0) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " is waiting for an object in the array");
				startTime = System.currentTimeMillis();
				wait(patience);
				if (System.currentTimeMillis() - startTime == patience) {
					System.out.println(Thread.currentThread().getName() + " got tired of waiting");
					return false;
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		list[--currentObject] = null;
		System.out.println(Thread.currentThread().getName() + " removed an object from the array");
		notifyAll();
		return true;
	}

	/**
	 * Print all the elements of the list.
	 */
	public void printAllElements() {
		for (int i = 0; i < currentObject; i++) {
			System.out.println(list[i]);
		}
	}
}
