class Solution {
    public int maxProfit(int[] prices) {
        int min_price=prices[0];
        int profit=0;
        for(int  i=1; i< prices.length; i++)
        {
            int diff = prices[i] - min_price;
            profit = Math.max(profit, diff);
            min_price = Math.min(min_price, prices[i]); 
        }
        return profit;
    }
}