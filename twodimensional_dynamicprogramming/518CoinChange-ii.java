package twodimensional_dynamicprogramming;

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // dp[a] = number of ways to make amount a
        dp[0] = 1; // 1 way to make amount 0
        // Iterate over coins in reverse order to avoid using the same coin multiple
        // times in one iteration
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int a = 1; a <= amount; a++) {
                dp[a] = dp[a] + (coins[i] <= a ? dp[a - coins[i]] : 0);
            }
        }
        return dp[amount];
    }
}
