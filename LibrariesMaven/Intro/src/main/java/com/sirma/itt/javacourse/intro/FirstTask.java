/**
 * 
 */
package com.sirma.itt.javacourse.intro;

import java.util.Random;

/**
 * @author gdimitrov
 */
public class FirstTask {
	/**
	 * Finds the greatest common divisor of two numbers
	 * 
	 * @param a
	 *            - the first number
	 * @param b
	 *            - the second number
	 * @return Returns a single integer
	 */
	public int gcd(int a, int b) {
		if (a == b) {
			return b;
		} else if (a > b)
			return gcd(a - b, b);
		else {
			return gcd(a, b - a);
		}

	}

	/**
	 * Finds the least common multiple of two numbers
	 * 
	 * @param a
	 *            - the first number
	 * @param b
	 *            - the second number
	 * @return Returns a single integer
	 */

	public int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	/**
	 * Finds the smallest number in an array of integers
	 * 
	 * @param array
	 *            - The input array
	 * @return Returns a single integer
	 */
	public int getMinElement(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return 0;
		}
		int min = array[0];
		for (int i : array) {
			if (min > i)
				min = i;
		}
		return min;
	}

	/**
	 * Finds the sum of all the numbers in an array of integers
	 * 
	 * @param array
	 *            - The input array
	 * @return Returns a single integer
	 */
	public int getSum(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return 0;
		}
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	/**
	 * Prints the entire array in the form [element1,element2,element3]
	 * 
	 * @param array
	 *            - The input array
	 */
	public String printArray(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return "[]";
		}
		StringBuilder result = new StringBuilder();
		result.append("[");
		int i = 0;
		for (; i < (array.length - 1); i++) {
			result.append(array[i]);
			result.append(",");
		}
		result.append(array[i]);
		result.append("]");
		return result.toString();
	}

	/**
	 * Finds the center of gravity of an array. The sum of elements before the center of gravity is
	 * the closest possible to the sum of the elements after it
	 * 
	 * @param array
	 *            - The input array
	 * @return Returns a single integer which is the index of the center of gravity
	 */
	public int centerOfGravity(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return 0;
		}
		int i = 0;
		int j = array.length - 1;
		int sum1 = 0;
		int sum2 = 0;
		while (i < j) {
			if (sum1 < sum2) {
				sum1 += array[i];
				i++;
			} else {
				sum2 += array[j];
				j--;
			}
		}
		return i;
	}

	/**
	 * This method sorts an array using the quicksort method
	 * 
	 * @param arr
	 *            - the array to be sorted
	 */
	public void quickSort(int[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return;
		}
		int right = arr.length - 1;
		quickSort(arr, 0, right);
	}

	/**
	 * This is the recursive overload of the function that splits the array in two and sorts it. It
	 * is used only internally, so the call to the function can be made using an array only, without
	 * pointing to it's end and beginning
	 * 
	 * @param arr
	 *            - the array to be sorted
	 * @param left
	 *            - the index that points to the beginning of the current array
	 * @param right
	 *            - the index that points to the end of the current array
	 */
	private void quickSort(int[] arr, int left, int right) {
		int i = left;
		int tmp;
		int j = right;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if (left < j) {
			quickSort(arr, left, j);
		}
		if (right > i) {
			quickSort(arr, i, right);
		}
	}

	/**
	 * This method reverses a given array without using additional arrays
	 * 
	 * @param arr
	 *            - The array that is going to be reversed
	 */
	public void reverse(int[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return;
		}
		int tmp;
		for (int i = 0; i < (arr.length / 2); i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}
	}

	/**
	 * This method generates a random string of lower and upper case letters and digits 0-9
	 * 
	 * @param length
	 *            - the length of the generated string
	 * @return Return a string that is the generated string
	 */
	public String stringGenerator(int length) {
		Random generator = new Random();
		int next;
		StringBuilder result = new StringBuilder();
		int valid = 0;
		while (valid < length) {
			next = generator.nextInt(124);
			if (validSymbol(next)) {
				result.append((char) next);
				valid++;
			}
		}
		return result.toString();
	}

	/**
	 * Checks if the symbol that is going to be appended is valid
	 * 
	 * @param next
	 *            - the symbol to be checked
	 * @return true if the symbol is valid, false if it isn't
	 */
	private boolean validSymbol(int next) {
		if ((next > 47) && (next < 58)) {
			return true;
		}
		if ((next > 64) && (next < 91)) {
			return true;
		}
		if ((next > 96) && (next < 123)) {
			return true;
		}

		return false;
	}
}
