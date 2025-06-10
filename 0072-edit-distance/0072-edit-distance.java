class Solution {  // optimised approach  TC: O(n*m)  SC: O(m)
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m= word2.length();   
        int []prev= new int[m+1];
        int []curr= new int[m+1];

        //index shifting to right---> dp table can't have -ive indexes
        //base case
        for(int j=0; j<=m; j++)
        prev[j]= j;

        for(int i=1; i<=n; i++)
        {
            curr[0]= i;
            for(int j=1; j<=m; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                curr[j]= 0 + prev[j-1];
                else
                curr[j]= 1 + Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}