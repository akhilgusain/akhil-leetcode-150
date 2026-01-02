package twodimensional_dynamicprogramming;

class Solution {
    private int[][] dp;
    private int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dp = new int[nums.length][2 * totalSum + 1]; // Offset by totalSum
        //  to handle negative indices
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) { // Base case
            return total == target ? 1 : 0; // Check if we reached the target
        }
        if (dp[i][total + totalSum] != Integer.MIN_VALUE) { // Memoization check
            return dp[i][total + totalSum]; // Return cached result
        }
        dp[i][total + totalSum] = backtrack(i + 1, total + nums[i], nums, target) +
                                  backtrack(i + 1, total - nums[i], nums, target);
        return dp[i][total + totalSum]; // Store and return the result
    }
}