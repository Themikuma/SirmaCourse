package com.sirma.itt.javacourse.threads;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.threads.counter.Counter;

/**
 * Tests on the counter thread.
 * 
 * @author gdimitrov
 */
public class CounterTest {

	/**
	 * Tests if the counter class keeps on executing even if the main thread is stopped.
	 */
	@Test
	public void testCounterByStopingAfterSleepingMain() {
		Counter counter = new Counter();
		Thread t = new Thread(counter);
		t.start();
		int firstValue = counter.getCurrent();
		try {
			Thread.sleep(200);
			counter.setRun(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int secondValue = counter.getCurrent();
		assertTrue(secondValue > firstValue);
	}

	/**
	 * Shows that the counter gives same values if it's stopped and the main thread is put to sleep.
	 */
	@Test
	public void testCounterByStopingBeforeSleepingMain() {
		Counter counter = new Counter();
		Thread t = new Thread(counter);
		t.start();
		int firstValue = counter.getCurrent();
		try {
			counter.setRun(false);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int secondValue = counter.getCurrent();
		assertTrue(secondValue == firstValue);

	}
}
