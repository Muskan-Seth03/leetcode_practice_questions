// TC: O(n)  SC: O(n)
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0)
        return t.charAt(0);
        
        int xor1 = (int) s.charAt(0);
        for(int i=1; i<s.length(); i++)
        {
            xor1 ^= s.charAt(i) - 'a';
        }
        int xor2 = (int) t.charAt(0);
        for(int i=1; i<t.length(); i++)
        {
            xor2 ^= t.charAt(i) - 'a';
        }
        return (char) ((xor1 ^ xor2) + 'a');
    }
}