package onedimensional_dynamicprogramming;

import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {
        // first max we are doing since for 1 element in nums then other two will return
        // 0
        return Math.max(nums[0],
                Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                        helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    // helper method that has code from House Robber1 problem
    private int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int newRob = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}
