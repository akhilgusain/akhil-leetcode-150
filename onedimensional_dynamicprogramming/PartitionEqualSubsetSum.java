package onedimensional_dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false; // If the total sum is odd, we cannot partition it into two equal subsets
        }
        // ex: nums = [1,5,11,5]
        // add each number from the end to the beginning
        // set dp will store all achievable sums
        // like dp = {0} initially
        // after adding 5, dp = {0,5}
        // after adding 11, dp = {0,5,11,16}
        // after adding 5, dp = {0,5,10,11,16,21}
        // after adding 1, dp = {0,1,5,6,10,11,16,17,21,22}
        // we can see that 11 is in dp, so we can partition the array into two subsets with equal sum
        Set<Integer> dp = new HashSet<>();
        dp.add(0); // Base case: a sum of 0 is always achievable
        int target = Arrays.stream(nums).sum() / 2; // We want to find a subset that sums to half of the total sum

        for (int i = nums.length - 1; i >= 0; i--) {
            // Create a new set for the next state
            Set<Integer> nextDP = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true; // Found a subset that sums to the target
                }
                nextDP.add(t + nums[i]); // Include the current number
                nextDP.add(t); // Exclude the current number
            }
            dp = nextDP; // Move to the next state
        }
        return false;
    }
}