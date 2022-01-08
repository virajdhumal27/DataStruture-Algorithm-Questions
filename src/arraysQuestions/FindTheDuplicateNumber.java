package arraysQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * Constraints:
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * 
 * Follow up:
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * 
 * 
 * Problem link: https://leetcode.com/problems/find-the-duplicate-number/
 */

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		FindTheDuplicateNumber obj = new FindTheDuplicateNumber();

		int[] nums = { 1, 3, 4, 2, 2 };

		int missing = obj.findDuplicate(nums);

		System.out.println(missing);
	}

	// Brute Force: TC O(NlogN) SC:O(1)
	public int findDuplicateBrute(int[] nums) {
		// Store total number of elements in variable n
		int n = nums.length;
		
		// Sort the entire array using Arrays.sort() utility function
		Arrays.sort(nums);
		
		// The duplicate number will be will be next to original number
		// Therefore iterate and just check current and next number, if same return that number
		for (int i = 0; i < n - 1; i++) {
			int current = nums[i];
			int next = nums[i + 1];
			if (current == next) {
				return current;
			}
		}
		
		// if no number is duplicate
		return -1;
	}
	
	// Better: TC: O(N) SC: O(N)
	public int findDuplicate(int[] nums) {
		// Store total number of elements in variable n
		int n = nums.length;
		
		// Creating a HashSet to store all numbers we have encountered
		Set<Integer> recordSet = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			int number = nums[i];
			
			// If number is already present in the set then number is duplicate number
			if(recordSet.contains(number)) {
				// return duplicate number
				return number;
			}
			
			// else add that number to set
			recordSet.add(number);
		}
		
		// If no number is found to be duplicate then return -1
		return -1;
	}

}
