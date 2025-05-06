class Solution {  // TC:O(m^2)  SC:O(m)    m-> pattern.length()
    public boolean wordPattern(String pattern, String s) {
        if(pattern.length() != s.split(" ").length)
        return false;
        if(s.length()==0)
        return false;

        String words[]= s.split(" ");
        
        HashMap<Character, String> map= new HashMap<>();

        for(int i=0; i < pattern.length(); i++)
        {
            char ch1= pattern.charAt(i);
            String word= words[i];
            if(map.containsKey(ch1))
            {
                if(!map.get(ch1).equals(word))
                return false;
            }
            else if(map.containsValue(word))   //map contains a key with the same value we were to set  
            {
                return false;
            }
            map.put(ch1, word);
        }     
        return true;
    }
}