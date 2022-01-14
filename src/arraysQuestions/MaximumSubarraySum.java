package arraysQuestions;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * 
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */

public class MaximumSubarraySum {

	public static void main(String[] args) {
		MaximumSubarraySum obj = new MaximumSubarraySum();

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = obj.maxSubArray(nums);
		System.out.println(maxSum);
	}

	// Kadane's Algorithm
	// Optimal: TC: O(N) SC: O(1)
	public int maxSubArray(int[] nums) {
		int n = nums.length;

		if (nums == null || n == 0) {
			return 0;
		}

		int maxSum = 0;
		int currSum = nums[0];
		for (int i = 0; i < n; i++) {
			currSum += nums[i];
			maxSum = Math.max(maxSum, currSum);
			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}

	// Better: TC: O(N^2) SC: O(1)
	public int maxSubArrayBetter(int[] nums) {
		int n = nums.length;

		if (nums == null || n == 0) {
			return 0;
		}

		int maxSum = nums[0];
		for (int i = 0; i < n; i++) {
			int currSum = 0;
			for (int j = i; j < n; j++) {
				currSum += nums[j];
				maxSum = Math.max(maxSum, currSum);
			}
		}

		return maxSum;
	}

	// Brute: TC: O(N^3) SC: O(1)
	public int maxSubArrayBrute(int[] nums) {
		int n = nums.length;

		if (nums == null || n == 0) {
			return 0;
		}

		int maxSum = nums[0];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int currSum = 0;
				for (int k = i; k <= j; k++) {
					currSum += nums[k];
				}
				maxSum = Math.max(maxSum, currSum);
			}
		}
		return maxSum;
	}
}
