// 2 pointer approach
// TC: O(n^2)  SC: O(n)    we can use hashmap or freq array
class Solution {
    private boolean isBalanced(Map<Character, Integer> map)
    {
        int temp = -1;
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(temp == -1)
            temp = entry.getValue();    // assign first freq
            else
            {
                if(entry.getValue() != temp)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen= 0;

        for(int i=0; i<n; i++)
        {
            Map<Character, Integer> map = new HashMap<>();
            for(int j= i; j<n; j++)
            {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
                if(isBalanced(map))
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}