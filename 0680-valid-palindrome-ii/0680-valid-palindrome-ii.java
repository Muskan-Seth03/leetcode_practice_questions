// TC: O(n)   SC: O(1)
class Solution {
    public boolean isPalindrome(String s, int l, int r)
    {
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r))
            return false;

            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n= s.length();

        int l =0;
        int r= s.length() - 1;
        
        while(l < r)
        {
            if(s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else {
                // try skipping either side
                return isPalindrome(s, l+1, r) ||
                       isPalindrome(s, l, r-1);
            }
        }
        return true;
    }
}
