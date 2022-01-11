package arraysQuestions;

import java.util.Arrays;

/*
 * Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array,
 * when n is the size of the first array, and m is the size of the second array.
 * 
 * Difficulty level: Hard
 * 
 * Example 1
 * Input: ar1[] = {10};
 * 		  ar2[] = {2, 3};
 * 
 * Output: ar1[] = {2}
 *  	   ar2[] = {3, 10}  
 *  
 *  Example 2
 *  Input: ar1[] = {1, 5, 9, 10, 15, 20};
 *  	   ar2[] = {2, 3, 8, 13};
 *  
 *  Output: ar1[] = {1, 2, 3, 5, 8, 9}
 *  ar2[] = {10, 13, 15, 20}
 *  
 *  Problem link: https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
 *  Solution link: https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=8
 */

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		int[] arr1 = { 1, 5, 9, 10, 15, 20 };
		int[] arr2 = { 2, 3, 8, 13 };

		MergeTwoSortedArrays obj = new MergeTwoSortedArrays();

		obj.mergeArrays(arr1, arr2);

		obj.printArray(arr1);
		obj.printArray(arr2);
	}

	// Brute
	public void mergeArrays(int[] arr1, int[] arr2) {

		int n = arr1.length;
		int m = arr2.length;

		// Defensive programming: Making sure values are in range.
		if (arr1 == null || arr2 == null || n == 0 || m == 0) {
			System.out.println("out");
			return;
		}

		int totalSize = n + m;
		int[] result = new int[totalSize];

		joinArray(result, arr1, arr2);

		Arrays.sort(result);

		splitArray(result, arr1, arr2);

	}

	// Join arr1 and arr2 in result array
	private void joinArray(int[] result, int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;

		for (int i = 0; i < n; i++) {
			result[i] = arr1[i];
		}

		int index = n;

		for (int i = 0; i < m; i++, index++) {
			result[index] = arr2[i];
		}
	}

	// Split result array in arr1 and arr2.
	private void splitArray(int[] result, int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		
		for (int i = 0; i < n; i++) {
			arr1[i] = result[i];
		}

		int index = n;

		for (int i = 0; i < m; i++, index++) {
			arr2[i] = result[index];
		}
	}

	private void printArray(int[] arr) {
		int n = arr.length;
		System.out.print("[ ");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[n - 1] + " ]");
	}

}
