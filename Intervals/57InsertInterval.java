package Intervals;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // Input: intervals = [[1,3],[6,9]]
        // newInterval = [2,5]

        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                // that means interval is not overlapping and can be added
                // for ex : intervals = [[2,3],[4,5]] and newInterval = [7,9]
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // for ex : intervals = [[2,3],[4,5]]
                // newInterval = [0,1]
                // since we need to add that newInterval before the interval
                res.add(newInterval);
                res.add(interval);
                newInterval = null; // since new interval has already been added
            } else {
                // overlapping scenario
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null)
            res.add(newInterval); // for overlapping scenario
        return res.toArray(new int[res.size()][]);
    }
}
