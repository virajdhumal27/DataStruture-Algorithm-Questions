package arraysQuestions;

/*
 * Sort colors
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * Problem Link - https://leetcode.com/problems/sort-colors/
 */
public class Sort012 {

	public static void main(String[] args) {
		Sort012 obj = new Sort012();

		int nums[] = { 2, 0, 2, 1, 1, 0 };
		int n = nums.length;
		obj.sortColors(nums);

		System.out.println();
		for (int i = 0; i < n - 1; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println(nums[n - 1]);
	}

	// Brute Force: TC: O(2N) SC: O(1)
	public void sortColorsBrute(int[] nums) {
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return;
		}
		
		// Initialize variable zeros, ones, twos to 0
		int zeros = 0;
		int ones = 0;
		int twos = 0;

		int n = nums.length;
		// Iterate the loop
		for (int i = 0; i < n; i++) {
			// count all zeros, ones, twos
			if (nums[i] == 0) {
				zeros++;
			} else if (nums[i] == 1) {
				ones++;
			} else {
				twos++;
			}
		}

		int i = 0;
		// Replace all no. of zeros, ones, twos in the array
		while (zeros > 0) {
			nums[i] = 0;
			i++;
			zeros--;
		}
		while (ones > 0) {
			nums[i] = 1;
			i++;
			ones--;
		}
		while (twos > 0) {
			nums[i] = 2;
			i++;
			twos--;
		}
	}

	// Efficient: TC O(N) SC:O(1)
	public void sortColors(int[] nums) {
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return;
		}
		
		// Initialize variables low and mid to 0 and high to n-1
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		// loop till mid crosses high
		while (mid < high) {
			switch (nums[mid]) {
			// if mid is 0, swap low and mid
			// increment low and mid
			case 0:
				swap(nums, low, mid);
				low++;
				mid++;
				break;
				
			// if mid is 1, then simply increment mid
			case 1:
				mid++;
				break;

			// if mid is 2, then swap mid and high
			// decrement high and loop will again check if mid is 0 or not
			case 2:
				swap(nums, mid, high);
				high--;
			}
		}
	}

	// Efficient swapping
	private void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

}
