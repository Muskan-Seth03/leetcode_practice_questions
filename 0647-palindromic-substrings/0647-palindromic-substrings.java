class Solution {  // brute force TC:O(n^3) SC:O(1)
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
            return false;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n= s.length();
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalindrome(s, i, j))
                {
                    count++;
                }
            }
        }
        return count;
    }
}