// TC: O(n)  SC: O(k)   k => unique characters in string
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        //sliding window approach
        
        int i = 0;
        int j = 0;
        int ans = 0;
        
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        while(j < n)
        {
            char ch = s.charAt(j);
            // check if ch is in map or not 
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) - 1); 
            
            
            int size = j - i + 1;
        
            if(size < m)
            {
                j++;
            }
            
            else if(size == m)
            {
                // check map if all values are 0
                boolean flag = true;
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
                    list.add(i);
                }
                if(map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1); 
                }
                i++;
                j++;
            }
        }
        return list;
    }
}