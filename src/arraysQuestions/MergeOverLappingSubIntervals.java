package arraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [start[i], end[i]], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start[i] <= end[i] <= 10^4
 * 
 * Problem link: https://leetcode.com/problems/merge-intervals/
 * Solution link: https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=10
 * 
 */

public class MergeOverLappingSubIntervals {

	public static void main(String[] args) {
		MergeOverLappingSubIntervals obj = new MergeOverLappingSubIntervals();

		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] overlappedIntervals = obj.merge(intervals);

		ArrayUtilCustom.print2dArray(overlappedIntervals);
	}

	// Optimal: TC: O(NlogN) + O(N) --> Sorting + traversing
	//			SC: O(N)
	public int[][] merge(int[][] intervals) {

		// Create a List<int[]> result
		List<int[]> result = new ArrayList<>();

		// If intervals is null or empty
		if (intervals == null || intervals.length == 0) {
			return result.toArray(new int[0][]);
		}
		
		// In question, there is no mention that intervals are sorted.
		// This sorts in ascending order of start point
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		// loop
		for (int[] current : intervals) {
			// If intervals are crossing
			if (current[0] <= end) {
				end = Math.max(current[1], end);
			} else {
				// else add to result list
				result.add(new int[] { start, end });
				
				// saving the current formed interval
				start = current[0];
				end = current[1];
			}
		}
		
		// End value of start and end is stored
		result.add(new int[] {start, end});
		return result.toArray(new int[0][]);
	}

}
