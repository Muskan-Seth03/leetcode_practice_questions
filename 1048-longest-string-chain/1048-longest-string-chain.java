// recursion + memoization
class Solution {
    int n;
    int[][] dp;
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
    public int LIS(String[] words, int currInd, int prevInd)
    {
        if(currInd >= words.length)
        return 0;

        if(dp[currInd][prevInd+1] != -1)
        return dp[currInd][prevInd+1];

        int skip = LIS(words, currInd + 1, prevInd);

        int take = 0;
        if(prevInd == -1 || isPredecessor(words[currInd], words[prevInd]))
        {
            take = 1 + LIS(words, currInd + 1, currInd);
        }
        return dp[currInd][prevInd+1] = Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n+1][n+1];

        for(int[] d: dp)
        {
            Arrays.fill(d, -1);
        }
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        return LIS(words, 0, -1);
    }
}