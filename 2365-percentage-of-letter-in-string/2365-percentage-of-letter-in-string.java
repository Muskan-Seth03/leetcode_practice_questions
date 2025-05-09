class Solution {
    public int percentageLetter(String s, char letter) {
        if(s.indexOf(letter)==-1)
        return 0;

        int n= s.length();
        int [] freq= new int[26];
        for(char c: s.toCharArray())
        {
            freq[c - 'a']++;
        }
        int count= freq[letter - 'a'];
        return (count * 100) /n;
        
    }
}