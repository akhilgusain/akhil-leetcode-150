package onedimensional_dynamicprogramming;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            // simplified version of cost[i] += Math.min(cost[i] + cost[i+1], cost[i] +
            // cost[i+2]);
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]); // since you can start from either 0 or 1
    }
}
