class Solution {   // space optimised approach  TC:O(n*2)  SC:O(1) 
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int ahead[]= new int [2];
        int curr[]= new int [2];

        //base case 
        ahead[0]=ahead[1]=0;
       
        int profit=0;
         for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], prices[ind] + ahead[0]);
                }

                curr[buy] = profit;
            }
            ahead= curr.clone();
        }
        return curr[0];
    }
}