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

		ArrayUtilCustom.printArray(arr1);
		ArrayUtilCustom.printArray(arr2);
	}

	// Optimal: TC: O(NlogN) SC: O(1);
	public void mergeArrays(int[] arr1, int[] arr2) {
		// Size of arr1 and arr2 in n and m respectively
		final int n = arr1.length;
		final int m = arr2.length;

		// Defensive programming: Making sure values are in range.
		if (arr1 == null || arr2 == null || n == 0 || m == 0) {
			System.out.println("out");
			return;
		}

		final int totalSize = m + n;

		// Create a variable gap, that will be equal to additon of length of both arrays
		int gap = totalSize;

		// do-while loop, because we need to execute when gap is 1 also.
		do {
			// gap = ceil(gap/2);
			gap = (int) Math.ceil((float) gap / 2);

			// firstIndex = 0, secondIndex = firstIndex + gap
			int firstIndex = 0;
			int secondIndex = firstIndex + gap;

			
			shellSort(arr1, arr2, n, totalSize, firstIndex, secondIndex);

		} while (gap != 1);

	}

	// Sort the 2 arrays based on gaps
	private void shellSort(int[] arr1, int[] arr2, int n, int totalSize, int firstIndex, int secondIndex) {
		
		// loop till secondIndex is less than total size.
		while (secondIndex < totalSize) {
			
			// if firstIndex >= n that means both firstIndex and secondIndex are in arr2
			if (firstIndex >= n) {
				int index1 = firstIndex - n;
				int index2 = secondIndex - n;
				if (arr2[index1] > arr2[index2]) {
					swap(arr2, arr2, index1, index2);
				}
			} // if secondIndex >= n that means firstIndex is in arr1 and secondIndex is in arr2
			else if (secondIndex >= n) {
				int arr1Index = firstIndex;
				int arr2Index = secondIndex - n;
				// if element at firstIndex is big then swap with element at secondIndex
				if (arr1[arr1Index] > arr2[arr2Index]) {
					swap(arr1, arr2, arr1Index, arr2Index);
				}
			} // This means both firstIndex and secondIndex are in arr1
			else {
				// if element at firstIndex is big then swap with element at secondIndex else
				// pass
				if (arr1[firstIndex] > arr1[secondIndex]) {
					swap(arr1, arr1, firstIndex, secondIndex);
				}
			}
			firstIndex++;
			secondIndex++;
		}

	}

	// Better: TC: O(N * M) SC: O(1)
	public void mergeArraysBetter(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;

		// Defensive programming: Making sure values are in range.
		if (arr1 == null || arr2 == null || n == 0 || m == 0) {
			System.out.println("out");
			return;
		}

		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr1[i] > arr2[index]) {
				swap(arr1, arr2, i, index);
				Arrays.sort(arr2);
			}
		}
	}

	// Efficient swap
	private void swap(int[] arr1, int[] arr2, int i, int j) {
		arr1[i] = arr1[i] ^ arr2[j];
		arr2[j] = arr1[i] ^ arr2[j];
		arr1[i] = arr1[i] ^ arr2[j];
	}

	// Brute: TC: O[(N + M)log(N + M)] SC: O(N + M)
	public void mergeArraysBrute(int[] arr1, int[] arr2) {

		// Size of arr1.
		int n = arr1.length;

		// Size of arr2.
		int m = arr2.length;

		// Defensive programming: Making sure values are in range.
		if (arr1 == null || arr2 == null || n == 0 || m == 0) {
			System.out.println("out");
			return;
		}

		// Total size of both arrays.
		int totalSize = n + m;
		int[] result = new int[totalSize];

		joinArray(result, arr1, arr2);

		// Or implement own sorting
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

}
