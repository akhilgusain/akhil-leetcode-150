package onedimensional_dynamicprogramming;

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num; // store the value of curMax * num before updating curMax
            // because curMax will be updated before using it to calculate curMin
            // store it in a temporary variable because curMax will be updated in the next line
            // we need the old value of curMax to calculate curMin

            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            // max can be either num * curMax, num * curMin or num itself
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            // min can be either tmp (old curMax * num), num * curMin or num itself

            res = Math.max(res, curMax); // update the result with the maximum product found so far
        }
        return res;
    }
}
