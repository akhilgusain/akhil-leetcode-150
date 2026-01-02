package onedimensional_dynamicprogramming;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length]; // Longest Increasing Subsequence
        Arrays.fill(LIS, 1); // Each element is an increasing subsequence of length 1 by itself

        for (int i = nums.length - 1; i >= 0; i--) { // Traverse from the end to the beginning
            for (int j = i + 1; j < nums.length; j++) { // Check elements to the right of i
                if (nums[i] < nums[j]) { // If nums[i] can extend 
                // the increasing subsequence ending at nums[j]
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]); // Update LIS[i]
                    //  if we found a longer subsequence
                }
            }
        }
        //ex : nums = [10,9,2,5,3,7,101,18]
        // Initial LIS = [1,1,1,1,1,1,1,1]
        // After processing, LIS = [4,3,3,3,2,2,1,1]
        // Here, LIS[0] = 4 means the longest increasing subsequence starting from index 0 (value 10) 
        // LIS array now contains the lengths of the longest increasing subsequences
        // starting from each index. The answer is the maximum value in LIS.
        return Arrays.stream(LIS).max().getAsInt();
    }
}
