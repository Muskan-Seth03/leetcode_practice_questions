// tabulation approach
class Solution {
    int n;
    int[] dp;
    public boolean isPredecessor(String a, String b)
    {
        if(a.length() - b.length() != 1 || b.length() >= a.length())
        return false;

        int i=0, j=0;
        while(i < a.length() && j < b.length())
        {
            if(a.charAt(i) == b.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(j == b.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n+1];
        
        Arrays.fill(dp, 1);
        
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int maxLIS = 1;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(isPredecessor(words[i], words[j]))
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }
        return maxLIS;
    }
}