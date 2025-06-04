class Solution {  // Optimised approach   TC:O(2*m)  SC:O(min(n,m))
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length())
        {
            String temp= text1;
            text1= text2;
            text2= temp;
        }
        int n= text1.length();
        int m= text2.length();

        int dp[]= new int[m+1];  // rows of m columns
        int prevDp[]= new int[m+1];

        //base case
        prevDp[m]=0;

        for(int i=n-1; i>=0; i--)
        {
            for(int j= m-1; j>=0; j--)
            {
                if(text1.charAt(i) == text2.charAt(j))   // if match found
                dp[j] = 1 + prevDp[j + 1];
                else
                dp[j] = 0 + Math.max(prevDp[j], dp[j + 1]);       
            }
            prevDp= dp.clone();
        }
        return prevDp[0];
    }
}