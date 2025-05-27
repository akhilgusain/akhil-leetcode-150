package arrays;

class Solution {
    public int maxProfit(int[] prices) {
        // minimize the buy value and maximize the sell value of a stock
        // set minimum value as first day value
        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            // if value is less than min then update min
            if(prices[i] < min ) min = prices[i];
            profit = Math.max(profit, prices[i] - min); // sell - buy price of stock to be maximized
        }
        return profit;
    }
}
