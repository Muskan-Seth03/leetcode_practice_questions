class Solution {   // memoization approach  TC:O(n*2)  SC:O(n*2) + O(n) 
    public static int f(int ind, int buy, int[]prices, int[][]dp)
    {
        int n= prices.length;
        //base case
        if(ind == n)
        return 0;

        if(dp[ind][buy]!= -1)
        return dp[ind][buy];

        int profit=0;
        if(buy==1)  //allowed to buy 
            profit= Math.max(-prices[ind] + f(ind+1, 0, prices, dp), 0 + f(ind+1, 1, prices, dp)); 
        
        else
            profit= Math.max(prices[ind] + f(ind+1, 1, prices, dp), 0 + f(ind+1, 0, prices, dp));
        return dp[ind][buy]= profit;
    }

    public int maxProfit(int[] prices) {
        int n= prices.length;
        int dp[][]= new int [n][2];

        for(int [] row: dp)
        Arrays.fill(row, -1);

        return f(0, 1, prices, dp);
    }
}