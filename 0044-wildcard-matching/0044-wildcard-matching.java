class Solution {  // memoization approach  TC: O(n*m)  SC: O(n*m) + O(n+m) 
    public static int f(String s, String p, int i, int j, int [][]dp)
    {
        //base case
        //p and s both gets exhausted
        if(i<0 && j<0) return 1;  // all matched
        //p gets exahusted , but s still left 
        if(j<0 && i>=0) return 0; 
        // p still left but s matched...
        // ensure that pattern only have * then return true else false
        if(i<0 && j>=0)
        {
            for(int ii= 0; ii<=j; ii++)
            {
                if(p.charAt(ii) != '*')
                return 0;
            }
            return 1;   
        } 

        if(dp[i][j]!=-1)
        return dp[i][j];

        if(p.charAt(j) == s.charAt(i) || p.charAt(j) =='?')
        return dp[i][j]= f(s, p, i-1, j-1, dp);
        if(p.charAt(j) =='*')
        return dp[i][j]= (f(s, p, i-1, j, dp)==1|| f(s, p, i, j-1, dp)==1) ? 1 : 0;
        else
        return 0;
    }
    public boolean isMatch(String s, String p) {
        int n= s.length();
        int m= p.length();
        int [][] dp= new int [n][m]; 
        for(int row[]: dp)
        Arrays.fill(row, -1);
        if(f(s, p, n-1, m-1, dp) > 0) 
        return true; 
        else 
        return false;
    }
}