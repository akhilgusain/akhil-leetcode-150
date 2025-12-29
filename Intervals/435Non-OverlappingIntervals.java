package Intervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // first we will sort all intervals by start value
// we will remove larger end value array since it gives possibility of eliminating overlapping
        // now we will move to next one since it is having larger end value
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            // now we check if the end value of prev and start value of current
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= prevEnd){
                prevEnd = end;
            }
            else{
                // means overlapping is there
                res++;
                prevEnd = Math.min(end, prevEnd); // we keep minimum end since it has greater chance of non overlapping
            }
        }
        return res;
    }
}
