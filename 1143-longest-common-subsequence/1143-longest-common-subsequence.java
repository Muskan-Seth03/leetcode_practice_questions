// tabulation approach + printing LCS
// TC: O(m*n)  SC: O(m*n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++)
        {
            t[i][0] = 0;
        }
        for(int j=0; j<=n; j++)
        {
            t[0][j] = 0;
        }

        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];  // coming diagonally
                }
                else
                {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }

        // printing lcs
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0)
        {
            if(text1.charAt(i-1) == text2.charAt(j-1))
            {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(t[i-1][j] > t[i][j-1])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
        }
        System.out.println(sb.reverse().toString());

        return t[m][n];
    }
}