class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int profit=0;
        int mini= Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            profit = prices[i]-mini;
            //first check profit  then update min buying rate
            max_profit= Math.max( max_profit, profit);
            
            mini= Math.min(mini, prices[i]);
        }
        return max_profit;
            
    }
}