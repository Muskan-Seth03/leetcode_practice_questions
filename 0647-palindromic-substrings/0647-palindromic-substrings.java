class Solution {  // better approach TC:O(n^2) SC:O(1)
    public int countSubstrings(String s) {
        int n= s.length();
        int count=0;
        for(int i=1; i<n; i++)
        {
            // odd length palindrome
            int l= i-1;
            int r= i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;
                r++;
            }
            //even length palindrome
            l= i-1;
            r= i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;
                r++;
            }
        }
        return count + n;
    }
}