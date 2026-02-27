// TC: O(n)  SC: O(1)
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0)
        return t.charAt(0);
        
        int xor1 = 0;
        for(int i=0; i<s.length(); i++)
        {
            xor1 ^= s.charAt(i) - 'a';
        }
        int xor2 = 0;
        for(int i=0; i<t.length(); i++)
        {
            xor2 ^= t.charAt(i) - 'a';
        }
        return (char) ((xor1 ^ xor2) + 'a');
    }
}