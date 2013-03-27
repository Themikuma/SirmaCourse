/**
 * 
 */
package com.sirmaitt.taks1tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Test;

import com.sirmaitt.tasks1.Tasks1;

/**
 * @author gdimitrov
 * 
 */
public class Tasks1Tests {

	private final static int SIZE = 99;
	private final static int MAX = 100;

	@Test
	public void testGCD() {
		Tasks1 provider = new Tasks1();
		assertEquals(3, provider.gcd(3, 6));
		assertEquals(121, provider.gcd(121, 121));
		assertEquals(6, provider.gcd(24, 6));
	}

	@Test
	public void testLCM() {
		Tasks1 provider = new Tasks1();
		assertEquals(6, provider.lcm(3, 6));
		assertEquals(121, provider.lcm(121, 121));
		assertEquals(24, provider.lcm(24, 6));
	}

	@Test
	public void testGetMinElement() {
		Tasks1 provider = new Tasks1();
		int[] testarr = { 4, 5, 2, 1, 89, -2 };
		assertEquals(-2, provider.getMinElement(testarr));
		int[] testarr2 = { 3 };
		assertEquals(3, provider.getMinElement(testarr2));
		int[] testarr3 = null;
		assertEquals(0, provider.getMinElement(testarr3));
		int[] testarr4 = {};
		assertEquals(0, provider.getMinElement(testarr4));
	}

	@Test
	public void testGetSum() {
		Tasks1 provider = new Tasks1();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals(15, provider.getSum(testarr));
		int[] testarr2 = { 3 };
		assertEquals(3, provider.getSum(testarr2));
		int[] testarr3 = null;
		assertEquals(0, provider.getSum(testarr3));
		int[] testarr4 = {};
		assertEquals(0, provider.getSum(testarr4));

	}

	@Test
	public void testPrintArray() {
		Tasks1 provider = new Tasks1();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals("[1,2,3,4,5]", provider.printArray(testarr));
		int[] testarr2 = { 3 };
		assertEquals("[3]", provider.printArray(testarr2));
		int[] testarr3 = null;
		assertEquals("[]", provider.printArray(testarr3));
		int[] testarr4 = {};
		assertEquals("[]", provider.printArray(testarr4));

	}

	@Test
	public void testCenterOfGravity() {
		Tasks1 provider = new Tasks1();
		int[] testarr = { 1, 2, 3, 4, 5 };
		assertEquals(3, provider.centerOfGravity(testarr));
		int[] testarr2 = { 3, 2, 2, 3, 2154 };
		assertEquals(3, provider.centerOfGravity(testarr2));
		int[] testarr3 = null;
		assertEquals(0, provider.centerOfGravity(testarr3));
		int[] testarr4 = {};
		assertEquals(0, provider.centerOfGravity(testarr4));

	}

	@Test
	public void testQuickSortEmpty() {
		Tasks1 provider = new Tasks1();
		provider.quickSort(new int[0]);
	}

	@Test
	public void testQuickSortSingle() {
		Tasks1 provider = new Tasks1();
		int[] tmp = new int[1];
		tmp[0] = 20;
		provider.quickSort(tmp);
	}

	@Test
	public void testQuickSort() {
		Random generator = new Random();
		int[] array = new int[SIZE];
		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt(MAX);
		}
		Tasks1 provider = new Tasks1();
		provider.quickSort(array);
		assertTrue(isSorted(array));
	}

	private boolean isSorted(int[] arr) {
		for (int i = 0; i < (arr.length - 1); i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testReverseEmpty() {
		Tasks1 provider = new Tasks1();
		provider.reverse(new int[0]);
	}

	@Test
	public void testReverseSingle() {
		Tasks1 provider = new Tasks1();
		int[] tmp = new int[1];
		tmp[0] = 20;
		provider.reverse(tmp);
	}

	@Test
	public void testReverse() {
		Tasks1 provider = new Tasks1();
		int[] array = new int[SIZE];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		provider.reverse(array);
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

	@Test
	public void testGenerator() {
		String result;
		Tasks1 provider = new Tasks1();
		for (int i = 1; i <= 500; i++) {
			result = provider.stringGenerator(i);
			assertEquals(i, result.length());
			assertTrue(validString(result));
		}
	}

	private boolean validString(String result) {
		if (Pattern.matches("[a-zA-Z0-9]+", result)) {
			return true;
		}
		return false;
	}
}
