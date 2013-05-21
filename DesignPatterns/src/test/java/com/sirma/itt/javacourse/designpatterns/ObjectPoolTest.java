package com.sirma.itt.javacourse.designpatterns;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ObjectPool design pattern implementation.
 * 
 * @author gdimitrov
 */
public class ObjectPoolTest {

	private ObjectPool pool;
	private static final int SIZE = 5;

	/**
	 * Sets up the tests by releasing any resources currently in use. This is necessary because the
	 * pool is implementing the singleton design pattern.
	 */
	@Before
	public void setup() {
		pool = new ObjectPool(SIZE);
	}

	/**
	 * Pulls less objects than the threshold of the pool.
	 */
	@Test
	public void testAcquireByGettingLessThanMaxObjects() {
		PooledClass object = pool.acquire();
		object = pool.acquire();
		assertNotNull(object);
	}

	/**
	 * Tries to pull more objects that the threshold allows. Should receive an exception.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAcquireByGettingMoreThanMaxObjects() {
		PooledClass object = pool.acquire();
		for (int i = 0; i < SIZE; i++) {
			object = pool.acquire();
		}
	}

	/**
	 * Tries to free resources without any being taken.
	 */
	@Test
	public void testReleaseWithoutTakingResources() {
		assertFalse(pool.release(new PooledClass()));
	}
}
