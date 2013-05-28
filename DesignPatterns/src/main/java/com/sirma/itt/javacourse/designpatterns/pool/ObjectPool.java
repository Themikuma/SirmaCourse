package com.sirma.itt.javacourse.designpatterns.pool;

import java.util.Stack;

/**
 * Implements a generic object pool.
 * 
 * @author gdimitrov
 */
public final class ObjectPool {
	private Stack<PooledClass> objects;
	private int maxNumberOfObjects;
	private int currentObjects;

	/**
	 * Creates an object pool with a given number of objects.
	 * 
	 * @param maxNumberOfObjects
	 *            - how many objects the pool will hold.
	 */
	public ObjectPool(int maxNumberOfObjects) {
		objects = new Stack<PooledClass>();
		this.maxNumberOfObjects = maxNumberOfObjects;
		currentObjects = 0;
	}

	/**
	 * Acquires an object from the pool.
	 * 
	 * @return the next unused object from the pool.
	 */
	public PooledClass acquire() {
		if (objects.isEmpty() && (currentObjects < maxNumberOfObjects)) {
			currentObjects++;
			return new PooledClass();
		} else if (objects.isEmpty()) {
			throw new IndexOutOfBoundsException("Out of resources");
		}
		return objects.pop();
	}

	/**
	 * Releases the given resource.
	 * 
	 * @param reusable
	 *            - the resource to be released.
	 * @return true if resources were freed.
	 */
	public boolean release(PooledClass reusable) {
		if (currentObjects > 0) {
			objects.add(reusable);
			currentObjects--;
			return true;
		}
		return false;
	}
}
