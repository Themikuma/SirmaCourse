package com.sirma.itt.javacourse.threads.timeouthashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This is a timeout hash table. When an element isn't used for a period of time it's automatically
 * removed from the table.
 * 
 * @author gdimitrov
 */
public class TimeoutHashtable implements Runnable {

	private HashMap<String, Object> items;
	private HashMap<String, Integer> times;
	private volatile boolean run;
	private final int patience;
	private final int refreshRate;

	/**
	 * Creates an empty TimeoutHashTable.
	 * 
	 * @param refreshRate
	 *            the refresh rate of the hash table.
	 * @param patience
	 *            the time to wait until removing an item from the hash table.
	 */
	public TimeoutHashtable(int refreshRate, int patience) {
		items = new HashMap<>();
		times = new HashMap<>();
		run = true;
		this.patience = patience;
		this.refreshRate = refreshRate;
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
	public synchronized void put(String key, Object value) {
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
	public synchronized Object get(String key) {
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
	public synchronized Object remove(String key) {
		times.remove(key);
		return items.remove(key);
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while (run) {
			refresh();
			try {
				Thread.sleep(refreshRate);
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
	private synchronized void refresh() {
		int time;
		String key = null;
		Set<String> keySet = items.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next();
			time = times.get(key);
			time += refreshRate;
			times.remove(key);
			if (time >= patience) {
				items.remove(key);
				break;
			}
			times.put(key, time);
		}
	}
}
