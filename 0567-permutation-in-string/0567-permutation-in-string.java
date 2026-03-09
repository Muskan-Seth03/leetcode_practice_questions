// sliding window  
// TC: O(n)  SC: O(k)    k-> length of pattern
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // sliding window approach
        int i = 0;
        int j = 0;

        int n= s2.length();
        int ans = 0;
        while(j < n)
        {
            if(map.containsKey(s2.charAt(j)))
                map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
            
            int size = j - i + 1;

            if(size < m)
            {
                j++;
            }
            else if(size == m)
            {
                boolean flag = true;
                // check in map if all value sare zero
                for(Integer val : map.values())
                {
                    if(val != 0)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    ans += 1;
                }
                if(map.containsKey(s2.charAt(i)))
                {
                    map.put(s2.charAt(i), map.get(s2.charAt(i)) + 1);
                }
                i++;
                j++;
            }
        }
        return ans > 0 ? true : false;
    }
}