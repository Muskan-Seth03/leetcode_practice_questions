// brute force approach
// TC: O(n)  SC: O(n)  using sb 
class Solution {
    public boolean checkPalindrome(String str)
    {
        int l =0;
        int r= str.length() - 1;
        while(l<r)
        {
            if(str.charAt(l) == str.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s) {
        int n= s.length();
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++)
        {
            char ch = Character.toLowerCase(s.charAt(i));
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(ch);                
            }
        }
        return checkPalindrome(sb.toString());
        
    }
}