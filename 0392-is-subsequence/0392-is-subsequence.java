// 2 pointer approach
// TC: O(n + m)  SC: O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length() && j <t.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        } 
        return i == s.length();
    }
}