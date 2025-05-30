class Solution {
    public int maxProfit(int[] prices) {
        int total_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total_profit += prices[i] - prices[i - 1]; 
            }
            else
            {
                total_profit+=0;
            }
        }
        return total_profit;
    }
}
