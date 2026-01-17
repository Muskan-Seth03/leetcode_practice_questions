// TC: O(n)  SC:O(1)
class Solution {
    public boolean isPalindrome(String temp, int l, int r)
    {
        while(l<r)
        {
            if(temp.charAt(l++) != temp.charAt(r--))
            {
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int l=0;
        int r= s.length() -1;

        if(isPalindrome(s, l, r))
        return true;

  
        while(l<r)   
        {
            if(s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
        }
        return false;
    }
}