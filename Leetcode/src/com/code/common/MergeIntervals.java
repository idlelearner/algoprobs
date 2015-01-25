package com.code.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge the given intervals if it overlaps
 * 
 * @author dhass
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		if (intervals.size() <= 1)
			return intervals;
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (prev.end < cur.start) {
				res.add(prev);
				prev = cur;
			} else {
				prev = new Interval(Math.min(prev.start, cur.start), Math.max(
						prev.end, cur.end));
			}
		}
		res.add(prev);
		return res;
	}
}
