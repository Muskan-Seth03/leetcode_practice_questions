// memoization approach DP + binary search.
// TC: O(n log n) for sorting + dp + binary search 
// SC: O(n * 3)
class Solution {
    Integer dp[][];
    public int compute(int[][] events, int ind)
    {
        int n= events.length;
        int ans= n;
        int low= ind+1;
        int high= n-1;
        int target= events[ind][1];

        while(low <= high)
        {
            int mid= (low + high)/2;
            if(events[mid][0] > target)
            {
                ans= mid;
                high= mid-1;
            }
            else
            {
                low= mid+1;
            }
        }
        return ans;
    }

    public int solve(int[][] events, int ind, int count)
    {
        int n= events.length;
        // base case
        if(ind == n || count == 2)
        return 0;

        if(dp[ind][count] != null){
            return dp[ind][count];
        }

        int exclude= solve(events, ind + 1, count);
        int nextInd= compute(events, ind);
        int include= events[ind][2] + solve(events, nextInd, count + 1);

        return dp[ind][count]= Math.max(include, exclude);
    }

    public int maxTwoEvents(int[][] events) {
        int n= events.length;
        dp= new Integer[n][3];
        Arrays.sort(events, (a, b)-> a[0] - b[0]);
        return  solve(events, 0, 0);     
    }
}