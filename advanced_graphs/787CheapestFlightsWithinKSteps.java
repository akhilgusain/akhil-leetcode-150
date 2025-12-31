package advanced_graphs;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford is used here
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) { // k+1 iterations for k stops
            int[] tmpPrices = Arrays.copyOf(prices, n); // make a copy to avoid using updated prices in the same iteration

            for (int[] flight : flights) {
                int s = flight[0]; // source
                int d = flight[1]; // destination
                int p = flight[2]; // price

                if (prices[s] == Integer.MAX_VALUE) { // if source is unreachable, skip
                    continue;
                }

                if (prices[s] + p < tmpPrices[d]) { 
                    tmpPrices[d] = prices[s] + p; // update the price to reach destination
                }
            }

            prices = tmpPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
