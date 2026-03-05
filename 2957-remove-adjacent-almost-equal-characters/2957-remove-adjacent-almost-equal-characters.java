// TC: O(n)  SC: O(1)
class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int n= word.length();
        int ans = 0;
        int i=1;
        while(i < n)
        {
            if(Math.abs(word.charAt(i) - word.charAt(i-1)) == 1 || word.charAt(i) == word.charAt(i-1))
            {
                ans++;
                i += 2;
            }
            else
            i++;
        }
        return ans;                                                                                                                            
    }
}