package com.sirma.itt.javacourse.threads.timeouthashtable;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * This is a timeout hash table. When an element isn't used for a period of time it's automatically
 * removed from the table.
 * 
 * @author gdimitrov
 */
public class TimeoutHashtable implements Runnable {

	private Hashtable<String, Object> items;
	private Hashtable<String, Integer> times;
	private volatile boolean run;
	private final int patience;

	/**
	 * Creates an empty TimeoutHashTable.
	 */
	public TimeoutHashtable() {
		items = new Hashtable<>();
		times = new Hashtable<>();
		run = true;
		patience = 1000;
	}

	/**
	 * Stops the hashTable.
	 */
	public void stop() {
		run = false;
	}

	/**
	 * Puts an item in the hash table. If the key already exists the item is replaced by the new
	 * one.
	 * 
	 * @param key
	 *            the key of the item
	 * @param value
	 *            the value of the item.
	 */
	public void put(String key, Object value) {
		if (items.containsKey(key)) {
			items.remove(key);
			times.remove(key);
		}
		items.put(key, value);
		times.put(key, 0);
	}

	/**
	 * Gets the item associated with the key. Returns null if no such item is found.
	 * 
	 * @param key
	 *            the key of the item.
	 * @return the value to which the specified key is mapped, or null if this map contains no
	 *         mapping for the key
	 */
	public Object get(String key) {
		if (items.containsKey(key)) {
			times.remove(key);
			times.put(key, 0);
		}
		return items.get(key);
	}

	/**
	 * Removes the mapping for the specified key from this map if present.
	 * 
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no mapping for key. (A
	 *         null return can also indicate that the map previously associated null with key.)
	 */
	public Object remove(String key) {
		times.remove(key);
		return items.remove(key);
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while (run) {
			refresh();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long runtime = System.currentTimeMillis() - start;
		System.out.println(runtime);
	}

	/**
	 * Refreshes the time spent for each item in the hash table and removes the ones who expired.
	 */
	private void refresh() {
		int time;
		String key = null;
		Enumeration<String> keys = times.keys();
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			time = times.get(key);
			time += 100;
			times.remove(key);
			if (time + 100 >= patience) {
				items.remove(key);
				continue;
			}
			times.put(key, time);
		}
	}
}
