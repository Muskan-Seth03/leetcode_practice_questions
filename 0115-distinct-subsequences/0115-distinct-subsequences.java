class Solution {  // 1-D Array space optimised approach  TC:O(n*m)   SC:O(m)
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m= t.length();
        int prev[]= new int [m+1];
        //base case
        prev[0]= 1;
   
        for(int i=1; i<=n; i++)
        {
            for(int j=m; j>=1; j--)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    prev[j]= prev[j-1] + prev[j]; 
                } 
            }
        }
        return prev[m];
    }
}