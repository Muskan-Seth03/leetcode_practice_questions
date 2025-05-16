class Solution {  //  brute force  TC:O(n^3)  SC:O(1)
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
    public String longestPalindrome(String s) {
        int n= s.length();
        int max_len=0;
        String str1= "";
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalindrome(s, i, j))
                {
                    if(j+1-i > max_len)
                    {
                        max_len= j+1-i;
                        str1= s.substring(i, j+1);

                    }
                }
            }
        }
        return str1;
    }
}