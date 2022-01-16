package arraysQuestions;

import java.util.ArrayList;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 * 
 * Problem link: https://www.interviewbit.com/problems/merge-intervals/
 * Solution link: https://www.youtube.com/watch?v=ANkkTJSk3KU&t=75s
 */

class Interval {
	int start;
	int end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class InsertInterval {

	public static void main(String[] args) {

		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		Interval newInterval = new Interval(4, 9);

		InsertInterval obj = new InsertInterval();

		intervals = obj.insert(intervals, newInterval);
		int n = intervals.size();

		System.out.print("{ ");
		for (int i = 0; i < n - 1; i++) {
			Interval interval = intervals.get(i);
			System.out.print("[" + interval.start + ", " + interval.end + "], ");
		}
		System.out.print("[" + intervals.get(n - 1).start + ", " + intervals.get(n - 1).end + "] }");

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		// If the list is null, make new and add newInterval.
		if(intervals == null) {
			intervals = new ArrayList<>();
			intervals.add(newInterval);
			return intervals;
		}
		
		// Storing newInterval in toInsert.
		Interval toInsert = newInterval;
		
		int i = 0;
		while(i < intervals.size()) {
			Interval current = intervals.get(i);
			
			// Current has not reached to toInsert.
			if(current.end < toInsert.start) {
				i++;
				continue;
			} else if (toInsert.end < current.start) {
				// current is forward and toInsert is back
				intervals.add(i, toInsert);
				break;
			} else {
				// Current is crossed with toInsert.
				toInsert.start = Math.min(toInsert.start, current.start);
				toInsert.end = Math.max(toInsert.end, current.end);
				intervals.remove(i);
			}
		}
		
		if(i == intervals.size()) {
			intervals.add(toInsert);
		}
		return intervals;
	}

}
