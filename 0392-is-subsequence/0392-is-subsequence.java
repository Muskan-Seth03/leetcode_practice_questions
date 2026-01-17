// TC: O(n * m)  SC: O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int prevIndex= -1;
        for(char c: s.toCharArray())
        {
            boolean found= false;
            for(int j= prevIndex + 1; j < t.length(); j++)
            {
                if(t.charAt(j) == c)
                {
                    prevIndex= j;
                    found= true;
                    break;
                }
            }
            if(!found) return false;
        }        
        return true;
    }
}