class Solution {   // optimization approach 
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[]prev= new int [amount + 1];
        int[]curr= new int [amount + 1];

        //base case 
        for (int i = 0; i <= amount; i++) {
        if (i % coins[0] == 0)
            prev[i] = i / coins[0];
        else
            prev[i] = (int) Math.pow(10, 9);
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);
                if (coins[ind] <= target)
                    take = 1 + curr[target - coins[ind]];
                curr[target] = Math.min(notTake, take);
            }
            prev= curr.clone();
        }
        int ans = prev[amount];

        if (ans >= (int)(1e9))
            return -1;
        return ans;
    }
}
