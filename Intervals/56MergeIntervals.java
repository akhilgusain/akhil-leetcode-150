package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        // now lets take 0th as previous and 1st as current array
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            // now lets compare the second value of previous with first value of current
            if (current[0] <= previous[1]) {
                // this is for ex : previous [1,3] and current [2,6]
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                merged.add(previous); // [1,6] is added
                previous = current; // [8,10] is previous
            }
        }
        // since a previous is remaining
        merged.add(previous);
        return merged.toArray(new int[merged.size()][]);
    }
}
