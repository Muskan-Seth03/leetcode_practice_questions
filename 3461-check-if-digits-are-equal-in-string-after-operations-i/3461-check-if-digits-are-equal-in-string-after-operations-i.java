// TC: O(n^2)  SC: O(n)
class Solution {
    public boolean hasSameDigits(String s) {
        // char[] chArray = s.toCharArray();
        int n= s.length();
        
        while(s.length() > 2)
        {
            StringBuilder sb= new StringBuilder();

            for(int i=0; i < s.length()-1; i++)
            {
                sb.append(((s.charAt(i) - '0') + (s.charAt(i+1)- '0')) % 10);
            }
            if(sb.length() == 2 && sb.charAt(0) == sb.charAt(1))
            {
                return true;
            }
            else if (sb.length() == 2 && sb.charAt(0) != sb.charAt(1))
            {
                return false;
            }
            // again iterate
            s= sb.toString();
        }
        return false;
    }
}