class Solution {  //TC: O(n)  SC:O(1)
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length())
        return false;

        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0; i< s.length(); i++)
        {
            char ch= s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch:t.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch)-1);
            }
            else
            return false;  

            if(map.get(ch)==0)
            map.remove(ch); 
        }
        if(!map.isEmpty())
        return false;
        else
        return true;

    }
}