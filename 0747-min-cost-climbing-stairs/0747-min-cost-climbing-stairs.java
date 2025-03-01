import java.util.*;
class Solution { // Space optimisation TC:O(n) SC:O(1)
    public int solve(int [] cost, int n){
        
        int prev2= cost[0];
        int prev1= cost[1];

        for(int i=2; i<n; i++)
        {
            int curr= cost[i]+ Math.min(prev1, prev2);
            prev2= prev1;
            prev1= curr;
        }
        return Math.min(prev1, prev2);
        
    }

    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;

        return solve(cost, n);
        
    }
}