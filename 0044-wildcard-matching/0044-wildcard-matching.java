class Solution {  // space optimisation approach  TC: O(n*m)  SC: O(m)
    public boolean isMatch(String s, String p) {
        int n= s.length();
        int m= p.length();
        int []prev= new int [m+1]; 
        int []curr= new int [m+1]; 

        //base case
        prev[0]= 1;

        for(int j=1; j<=m; j++)
        {
            int flag= 1;
            for(int ii= 1; ii<=j; ii++)
            {
                if(p.charAt(ii-1) != '*')
                {
                    flag= 0;
                    break;
                }
            }
            prev[j]= flag;   
        }

        for(int i=1; i<=n; i++)
        {
            curr[0]= 0;
            for(int j=1; j<=m; j++)
            {
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) =='?')
                curr[j]= prev[j-1];
                else if(p.charAt(j-1) =='*')
                curr[j]= (prev[j] ==1 || curr[j-1] ==1) ? 1 : 0;
                else
                curr[j]=0;
            }
            prev= curr.clone();
        }
        if(prev[m] > 0)
        return true;
        else
        return false;
    }
}