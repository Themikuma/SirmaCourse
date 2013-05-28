package com.sirma.itt.javacourse.designpatterns;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sirma.itt.javacourse.designpatterns.factory.MyFactory;

/**
 * Test the class implementing the Factory design pattern.
 * 
 * @author gdimitrov
 */
public class MyFactoryTest {

	/**
	 * Tests the createMap method by passing an input that will produce a map.
	 */
	@Test
	public void testCreateMapWithAValidMap() {
		Map<String, String> map = MyFactory.createMap("hash");
		assertEquals(HashMap.class, map.getClass());
	}

	/**
	 * Tests the createMap method by passing an input that will not produce a map.
	 */
	@Test
	public void testCreateMapWithInvalidMap() {
		Map<String, String> map = MyFactory.createMap("wrong");
		assertEquals(null, map);
	}

	/**
	 * Tests the createObjectByClassName method by passing input that will produce a valid class.
	 */
	@Test
	public void testCreateObjectByClassName() {
		Object object = MyFactory.createObjectByReflection("java.util.ArrayList");
		assertEquals(ArrayList.class, object.getClass());
	}

	/**
	 * Tests the createObjectByClassName method by passing input that will not produce a valid
	 * class.
	 */
	@Test
	public void testCreateObjectByInvalidClassName() {
		Object object = MyFactory.createObjectByReflection("invalid");
		assertEquals(null, object);
	}
}
