class Solution {  // space optimised approach  TC:O(n*m)   SC:O(n*m)
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m= t.length();
        int prev[]= new int [m+1];
        int curr[]= new int [m+1];
        //base case
        prev[0]= 1;
   
        for(int i=1; i<=n; i++)
        {
            curr[0]=1;
            for(int j=1; j<=m; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    curr[j]= prev[j-1] + prev[j]; 
                }
                else
                curr[j]= prev[j]; 
            }
            prev= curr.clone();
        }
        return prev[m];
    }
}