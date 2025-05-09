class Solution {
    public int firstUniqChar(String s) {
        // freq array
        int [] freq= new int [26];  // string consist of only lowercase letters
        for(char c: s.toCharArray())
        {
            freq[c - 'a']++;
        }
        for(int i=0; i< s.length(); i++)
        {
            if(freq[s.charAt(i) - 'a'] ==1)
            return i;
        }
        return -1; 
    }
}