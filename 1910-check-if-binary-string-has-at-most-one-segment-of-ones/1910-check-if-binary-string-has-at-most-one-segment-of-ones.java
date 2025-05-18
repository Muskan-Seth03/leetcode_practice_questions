class Solution {  // TC:O(n)  SC:O(1)
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        // starting el is 1 
        // if we encounter a '1' just after a '0', it means we have encountered a second '1'
        for(int i=1; i<n; i++)
        {
            if(s.charAt(i-1)=='0' && s.charAt(i)=='1')
            {
                return false; // second '1' found
            }
        } 
        return true;
    }
}