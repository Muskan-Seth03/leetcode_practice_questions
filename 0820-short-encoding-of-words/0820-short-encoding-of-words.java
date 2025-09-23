// brute force
// TC: O(n^2. m)  SC: O(n.m)    where n= no. of words in words array 
// m= Avg length of word  
class Solution {
    public int minimumLengthEncoding(String[] words) {
        // sorting needed for cases like ["me", "time"]
        Arrays.sort(words, (a,b)-> b.length() - a.length() ); 
        // sort in descending order of their len

        StringBuilder sb = new StringBuilder();
        for(String s: words)
        {
            if(sb.indexOf(s+"#") == -1)
            {
                sb.append(s + "#");
            }
        }
        return sb.length();
        
    }
}