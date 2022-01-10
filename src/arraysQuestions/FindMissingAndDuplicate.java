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

	// Naive: TC: O(N) SC: O(N)
	public int[] findMissingAndDuplicateNumber(int[] arr) {
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
			if(missingFound && repeatingFound) {
				break;
			}
		}

		// Return the result
		return result;
	}

}
