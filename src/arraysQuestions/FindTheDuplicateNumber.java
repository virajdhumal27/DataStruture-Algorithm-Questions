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
 * Solution link: https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=6
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
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		// Store total number of elements in variable n
		int n = nums.length;

		// ALWAYS AVOID THIS (Because it changes original array)
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
	// If use of external library is not allowed.
	public int findDuplicateBetter2(int[] nums) {
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		// Store total number of elements in variable n.
		int n = nums.length;
		
		// Frequency array to count occurrences of elements in nums array.
		int[] freq = new int[n+1];
		
		// To set all others to 0 also.
		freq[0] = 0;
		
		
		for(int i = 0; i < n; i++) {
			freq[nums[i]]++;
		}
		
		// Finding which number has frequency 2, starting from 2nd index as 1st index will always be zero.
		for(int i = 1; i < n+1; i++) {
			if(freq[i] == 2) {
				return i;
			}
		}
		
		// If no number is duplicate.
		return -1;
	}

	// Better: TC: O(N) SC: O(N)
	public int findDuplicateBetter(int[] nums) {
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		// Store total number of elements in variable n.
		int n = nums.length;

		// Creating a HashSet to store all numbers we have encountered
		Set<Integer> recordSet = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int number = nums[i];

			// If number is already present in the set then the duplicate number will be
			// next to original number
			if (recordSet.contains(number)) {
				// return duplicate number
				return number;
			}

			// else add that number to set
			recordSet.add(number);
		}

		// If no number is found to be duplicate then return -1
		return -1;
	}

	// Optimized: TC: O(N) SC: O(1)
	// Linked List cycle method
	public int findDuplicate(int[] nums) {
		// Defensive programming: Making sure values are in range.
		if(nums == null || nums.length == 0) {
			return -1;
		}

		// Initialize 2 variables slow and fast to start of the array(first number of
		// array).
		// Slow moves 1 step while fast moves 2 step at once.
		int slow = nums[0];
		int fast = nums[0];

		// The idea is there are number 1 to n and one number is duplicate
		// So a cycle will be formed (always).

		// Run a do while loop till fast and slow collide
		do {
			// Assign slow to nums[slow]. This will point to next number.
			slow = nums[slow];
			// Assign fast to nums[nums[fast]]. This point to next to next number.
			fast = nums[nums[fast]];
		} while (slow != fast);

		// Assign fast pointer to start and move slow and fast pointer 1 step
		// simultaneously.
		fast = nums[0];

		// When they collide then the number they are pointing will be duplicate number.
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		// return that number
		return slow;
	}

}
