/**
 * @author Georgi Dimitrov
 * 
 */
public class TasksGeorgiDimitrov {

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
		else
			return gcd(a, b - a);

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
		return a * b / gcd(a, b);
	}

	/**
	 * Finds the smallest number in an array of integers
	 * 
	 * @param array
	 *            - The input array
	 * @return Returns a single integer
	 */
	public int getMinElement(int[] array) {
		if (array.length == 0) {
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
	public void printArray(int[] array) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		for (; i < array.length - 1; i++) {
			result.append(array[i]);
			result.append(",");
		}
		result.append(array[i]);
		result.append(",");
		System.out.println(result);
	}

	/**
	 * Finds the center of gravity of an array. The sum of elements before the
	 * center of gravity is the closest possible to the sum of the elements
	 * after it
	 * 
	 * @param array
	 *            - The input array
	 * @return Returns a single integer which is the index of the center of
	 *         gravity
	 */
	public int centerOfGravity(int[] array) {
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
}
