// memoization approach
// TC: (m * n) SC: O(m * n)
class Solution {
    int[][] dp;
    int m, n;
    public int solve(int i, int j, String word1, String word2)
    {
        // if i and j th char is empty
        if( i>= m && j>= n)
        return 0;
        
        if(dp[i][j] != -1)
        return dp[i][j];

        // if i or j th char is empty
        if(i >= m)
        {
            return 1 + solve(i, j+1, word1, word2);
        }
        if(j >= n)
        {
            return 1 + solve(i+1, j, word1, word2);
        }

        if(word1.charAt(i) == word2.charAt(j))
        {
            return 0 + solve(i+1, j+1, word1, word2);
        }
        // if non empty and not same , 2 options
        int delete_s1_i= 1 + solve(i+1, j, word1, word2);
        int delete_s2_j= 1 + solve(i, j+1, word1, word2);

        return dp[i][j]= Math.min(delete_s1_i, delete_s2_j);
    }
    public int minDistance(String word1, String word2) {
        m= word1.length();
        n= word2.length();
        dp= new int[1001][1001];

        for(int i=0; i< dp.length; i++)
        Arrays.fill(dp[i], -1);

        return solve(0, 0, word1, word2);    
    }
}
    