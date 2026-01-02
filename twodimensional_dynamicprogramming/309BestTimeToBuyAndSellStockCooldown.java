package twodimensional_dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) { // no more days left
            return 0;
        }

        String key = i + "-" + buying; // unique key for memoization
        if (dp.containsKey(key)) { // already computed
            return dp.get(key); // return cached result
        }

        int cooldown = dfs(i + 1, buying, prices); // cooldown option, i+1 since we skip current day
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            // choose the maximum of buying or cooldown
            // false indicates we have bought a stock
            // i+1 since we move to next day
            dp.put(key, Math.max(buy, cooldown));
        } else {
            // selling case
            // true indicates we have sold a stock
            // i+2 since we have a cooldown day after selling
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
