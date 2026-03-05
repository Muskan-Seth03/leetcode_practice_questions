// TC: O(n)  SC: O(2*n)
class Solution {
    public int minOperations(String s) {
        int n= s.length();

        // create alternating string of len n 
        StringBuilder sb1 = new StringBuilder();

        for(int i=0; i<n; i++)
        {
            if(i % 2 == 0)
            {
                sb1.append('1');
            }
            else
            {
                sb1.append('0');
            }
        } 
        StringBuilder sb2 = new StringBuilder();

        for(int i=0; i<n; i++)
        {
            if(i % 2 == 0)
            {
                sb2.append('0');
            }
            else
            {
                sb2.append('1');
            }
        } 
        String s1 = sb1.toString();
        String s2 = sb2.toString();

        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == s1.charAt(i))
            {
                continue;
            }
            else
            {
                count1++;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == s2.charAt(i))
            {
                continue;
            }
            else
            {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}