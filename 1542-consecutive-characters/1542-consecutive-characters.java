class Solution {  //TC: O(n)  SC:O(1)
    public int maxPower(String s) {
        if(s.length() < 2) return 1;
        int maxLen= 0, len=0;
        for(int i=0; i < s.length()-1; i++)
        {
            char ch= s.charAt(i);
            len++;

            if(ch != s.charAt(i+1))
            {
                maxLen = Math.max(maxLen, len);
                len = 0;
            }
        }  
        // handle last character
        if (s.charAt(s.length()-2) == s.charAt(s.length()-1))
        {
            len++;
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}