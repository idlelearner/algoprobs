package com.code.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge the given interval in the sorted interval list
 * 
 * @author dhass
 *
 */
public class InsertInterval {
	public static void main(String[] args) {
		InsertInterval i = new InsertInterval();
		List<Interval> in = new ArrayList<Interval>();
		in.add(new Interval(1, 5));
		List<Interval> res = i.insert(in, new Interval(0, 3));
		for (Interval j : res)
			System.out.println(j.start + " : " + j.end);
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (newInterval.end < cur.start) {
				res.add(newInterval);
				newInterval = cur;
			} else if (cur.end < newInterval.start) {
				res.add(cur);
			} else {
				newInterval = new Interval(Math.min(newInterval.start,
						cur.start), Math.max(newInterval.end, cur.end));
			}
		}
		res.add(newInterval);
		return res;
	}

	// public List<Interval> insert(List<Interval> intervals, Interval
	// newInterval) {
	// List<Interval> result = new ArrayList<Interval>();
	// Interval insert = newInterval;
	// for (int i = 0; i < intervals.size(); i++) {
	// Interval cur = intervals.get(0);
	// // if the new interval is before the current element insert it
	// if (insert != null) {
	// if (insert.start < cur.start && insert.end < cur.start) {
	// result.add(insert);
	// i--;
	// insert = null;
	//
	// } else if (insert.start > cur.end)
	// result.add(cur);
	// else if (insert.end < cur.start)
	// result.add(cur);
	// if (cur.start <= insert.start && cur.end <= insert.end) {
	// insert.start = cur.start;
	// insert.end = cur.end;
	// }
	// if (cur.start >= insert.start && cur.end >= insert.start)
	// insert.start = cur.start;
	// if (cur.start <= insert.end && cur.end >= insert.end)
	// insert.end = cur.end;
	// } else
	// result.add(cur);
	// }
	// if (insert != null)
	// result.add(insert);
	// return result;
	// }
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
