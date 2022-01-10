package arraysQuestions;

/* Given an unsorted array of size n.
 * Array elements are in the range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the array.
 * Find these two numbers.
 * 
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 * Explanation: In the array, 2 is missing and 3 occurs twice 
 * 
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * Output: Missing = 5, Repeating = 1
 * 
 * Problem link: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * Solution link: https://www.youtube.com/watch?v=5nMGY4VUoRY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=7
 */

public class FindMissingAndDuplicate {

	public static void main(String[] args) {

		FindMissingAndDuplicate obj = new FindMissingAndDuplicate();

		int arr[] = { 4, 3, 6, 2, 1, 1 };

		int result[] = obj.findMissingAndDuplicateNumber(arr);

		System.out.println("Missing Number: " + result[0] + "\nRepeating number: " + result[1]);

	}

	// Optimal: TC: ~O(5N) SC: O(1)
	public int[] findMissingAndDuplicateNumber(int[] arr) {

		// Total elements in array.
		int n = arr.length;
		// Initialize variable XOR as 0.
		int XOR = 0;

		// XOR all elements in a variable.
		// Then XOR with numbers 1 to n.
		for (int i = 0; i < n; i++) {
			XOR ^= arr[i];
			XOR ^= i + 1;
		}

		// The XOR value now will be the the x-or of missing and repeating number.
		// Get the right most bit of XOR using getRightMostSetBit() method and store in
		// bitIndex variable.
		int bitIndex = getRightMostSetBit(XOR);

		// Create 2 buckets and initialize to zero
		int bucket1 = 0;
		int bucket2 = 0;

		// Separate elements in 2 buckets on the basis of set bit index.
		for (int number : arr) {

			if (isSetBit(number, bitIndex)) {
				bucket1 ^= number;
			} else {
				bucket2 ^= number;
			}

		}

		// Now from elements 1 to n, separate these numbers in 2 buckets same as we
		// separated elements.
		for (int i = 1; i <= n; i++) {
			if (isSetBit(i, bitIndex)) {
				bucket1 ^= i;
			} else {
				bucket2 ^= i;
			}
		}

		// Now it is guaranteed that one bucket has missing and another has repeating
		// number.
		// To find out traverse the array again.

		// result[0] = missing
		// result[1] = duplicate
		int result[] = { bucket1, bucket2 };

		for (int number : arr) {
			// if the number is same as element in bucket1 that means it's repeating number
			// we want it in bucket2
			if (number == bucket1) {
				result[0] = bucket2;
				result[1] = bucket1;
				break;
			}
		}

		// Return the result
		return result;
	}

	// To check if a number has a bit set or not at given index
	// Example: 4
	// 4 in binary is 1 0 0
	// index         ->  3 2 1
	// binary number ->  1 0 0
	// Index 3 is set bit meanwhile index 2 and 1 are not
	private boolean isSetBit(int number, int index) {
		int mask = (1 << index) & number;

		if (mask != 0) {
			return true;
		}
		return false;
	}

	// To get index of right most set bit
	// Example: 9
	// 9 in binary is 1 0 0 1
	// index 		 -> 4 3 2 1
	// binary number -> 1 0 0 1
	// Index 4 is right most binary number
	private int getRightMostSetBit(int number) {
		int bitIndex = 0;
		int i = 31;
		while (i >= 0) {
			int mask = (1 << i) & number;
			if (mask != 0) {
				bitIndex = i;
				break;
			}
			i--;
		}
		return bitIndex;
	}

	// Naive: TC: O(2N) SC: O(N + 1)
	public int[] findMissingAndDuplicateNumberBrute(int[] arr) {
		// Store total number of elements in variable n.
		int n = arr.length;

		// Frequency array to count occurrences of elements in nums array.
		int[] freq = new int[n + 1];

		// To set all others to 0 also
		freq[0] = 0;

		for (int i = 0; i < n; i++) {
			freq[arr[i]]++;
		}

		// result[0] = missing
		// result[1] = duplicate
		int[] result = new int[2];
		boolean missingFound = false;
		boolean repeatingFound = false;

		// Finding which number has frequency 2, starting from 2nd index as 1st index
		// will always be zero.
		for (int i = 1; i < n + 1; i++) {
			if (freq[i] == 0) {
				result[0] = i;
				missingFound = true;
			} else if (freq[i] == 2) {
				result[1] = i;
				repeatingFound = true;
			}

			// If both numbers are found, no need to check further.
			if (missingFound && repeatingFound) {
				break;
			}
		}

		// Return the result
		return result;
	}

}
