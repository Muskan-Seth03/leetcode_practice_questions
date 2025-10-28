// TC: O(n + m)
// SC: O(n)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // build the diff array
        int n= s.length();

        int[] diff= new int[n];
        
        for(int[] shift: shifts)
        {
            int l= shift[0];
            int r= shift[1];
            int dir= shift[2];

            int x= (dir == 0) ? -1 : 1;
            diff[l] += x;
            // safety check
            if(r+1 < n)
            diff[r+1] -= x;  
        }
        // find cum diff array
        
        for (int i = 1; i < n; i++) 
        diff[i] += diff[i - 1];
        
        for (int i = 0; i < n; i++) {
            diff[i] %= 26;
            if (diff[i] < 0) diff[i] += 26;
        }

        // wrap around val under 26
        // now add diff[i] to ith char of string s

        StringBuilder sb= new StringBuilder(s);
        for(int k=0; k<n; k++)
        {
            // wrap around after applying shift to char of string s
            sb.setCharAt(k, (char)((sb.charAt(k) - 'a' + diff[k]) % 26 + 'a'));
        }
        return sb.toString();        
    }
}