package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for the first seven tasks of the first task package.
 * 
 * @author gdimitrov
 */
public class FirstTaskTest {

	private final static int SIZE = 99;
	private final static int MAX = 100;

	/**
	 * Testing the greatest common divisor function. The three asserts test all code paths.
	 */
	@Test
	public void testGCD() {
		new FirstTask();
		assertEquals(3, FirstTask.gcd(3, 6));
		assertEquals(121, FirstTask.gcd(121, 121));
		assertEquals(6, FirstTask.gcd(24, 6));
	}

	/**
	 * Testing the lowest common divisor multiplier. The three asserts test all code paths.
	 */
	@Test
	public void testLCM() {
		new FirstTask();
		assertEquals(6, FirstTask.lcm(3, 6));
		assertEquals(121, FirstTask.lcm(121, 121));
		assertEquals(24, FirstTask.lcm(24, 6));
	}

	/**
	 * Testing the function to get the smallest element of an array. The four asserts check all code
	 * paths
	 */
	@Test
	public void testGetMinElement() {
		new FirstTask();
		int[] testarr = { 4, 5, 2, 1, 89, -2 };
		assertEquals(-2, FirstTask.getMinElement(testarr));
		int[] testarr2 = { 3 };
		assertEquals(3, FirstTask.getMinElement(testarr2));
		int[] testarr3 = null;
		assertEquals(0, FirstTask.getMinElement(testarr3));
		int[] testarr4 = {};
		assertEquals(0, FirstTask.getMinElement(testarr4));
	}

	/**
	 * Testing the function to get the sum of an array. The four asserts check all code paths
	 */
	@Test
	public void testGetSum() {
		new FirstTask();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals(15, FirstTask.getSum(testarr));
		int[] testarr2 = { 3 };
		assertEquals(3, FirstTask.getSum(testarr2));
		int[] testarr3 = null;
		assertEquals(0, FirstTask.getSum(testarr3));
		int[] testarr4 = {};
		assertEquals(0, FirstTask.getSum(testarr4));

	}

	/**
	 * Testing the function to print an array. The four asserts check all code paths
	 */
	@Test
	public void testPrintArray() {
		new FirstTask();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals("[1,2,3,4,5]", FirstTask.printArray(testarr));
		int[] testarr2 = { 3 };
		assertEquals("[3]", FirstTask.printArray(testarr2));
		int[] testarr3 = null;
		assertEquals("[]", FirstTask.printArray(testarr3));
		int[] testarr4 = {};
		assertEquals("[]", FirstTask.printArray(testarr4));

	}

	/**
	 * Testing the function to get the center of gravity of an array. The four asserts check all
	 * code paths
	 */
	@Test
	public void testCenterOfGravity() {
		new FirstTask();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals(3, FirstTask.centerOfGravity(testarr));
		int[] testarr2 = { 3, 2, 2, 3, 2154 };
		assertEquals(3, FirstTask.centerOfGravity(testarr2));
		int[] testarr3 = null;
		assertEquals(0, FirstTask.centerOfGravity(testarr3));
		int[] testarr4 = {};
		assertEquals(0, FirstTask.centerOfGravity(testarr4));

	}

	/**
	 * This tests the quicksort function's behavior when it's called using an empty array
	 */
	@Test
	public void testQuickSortEmpty() {
		new FirstTask();
		FirstTask.quickSort(new int[0]);
	}

	/**
	 * This tests the quicksort function's behavior when it's called using a single value in an
	 * array
	 */
	@Test
	public void testQuickSortSingle() {
		new FirstTask();
		int[] tmp = new int[1];
		tmp[0] = 20;
		FirstTask.quickSort(tmp);
		assertTrue(isSorted(tmp));
	}

	/**
	 * This tests the quicksort function's behavior when it's called using a random array
	 */
	@Test
	public void testQuickSort() {
		Random generator = new Random();
		int[] array = new int[generator.nextInt(SIZE)];
		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt(MAX);
		}
		new FirstTask();
		FirstTask.quickSort(array);
		assertTrue(isSorted(array));
	}

	/**
	 * Checks whether the array is sorted
	 * 
	 * @param arr
	 *            - the array to be checked
	 * @return true if the array is sorted, false if it's not
	 */
	private boolean isSorted(int[] arr) {
		for (int i = 0; i < (arr.length - 1); i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This tests the reverse function's behavior when it's called using an empty array
	 */
	@Test
	public void testReverseEmpty() {
		new FirstTask();
		FirstTask.reverse(new int[0]);
	}

	/**
	 * This tests the reverse function's behavior when it's called using a single value in an array
	 */
	@Test
	public void testReverseSingle() {
		new FirstTask();
		int[] tmp = new int[1];
		tmp[0] = 20;
		FirstTask.reverse(tmp);
	}

	/**
	 * This tests the reverse function's behavior when it's called using the array [1,2...SIZE]
	 */
	@Test
	public void testReverse() {
		new FirstTask();
		int[] array = new int[SIZE];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		FirstTask.reverse(array);
		assertTrue(isReversed(array));
	}

	private boolean isReversed(int[] array) {
		for (int i : array) {
			if (array[i] != (SIZE - i - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Tests the string generator. Considering the generator generates random values the function is
	 * called 5000 times and each time the length and if the string is generated only using lower
	 * and upper case letters and numbers
	 */
	@Test
	public void testGenerator() {
		String result;
		new FirstTask();
		for (int i = 1; i <= 5000; i++) {
			result = FirstTask.stringGenerator((i % 500) + 1);
			assertEquals((i % 500) + 1, result.length());
			assertTrue(validString(result));
		}
	}

	/**
	 * Validates if the input string is a valid string
	 * 
	 * @param generated
	 *            - the string to be validated
	 * @return - true if the string is valid and false if it contains an invalid character
	 */
	private boolean validString(String generated) {
		if (Pattern.matches("[a-zA-Z0-9]+", generated)) {
			return true;
		}
		return false;
	}
}
