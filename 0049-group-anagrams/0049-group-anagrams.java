class Solution {
    public boolean isAnagram(String s, String t)
    {
        int n= s.length();
        if(s.length()!= t.length())
        return false;

        int [] freq= new int[26];
        for(int i=0; i<n; i++)
        {
            freq[ s.charAt(i)- 'a']++;
            freq[ t.charAt(i) -'a']--;
        }

        for(int c: freq)
        {
            if(c!=0)
            return false;
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();

        // Anagrams can be duplicate strings (e.g., ["bat", "tab", "bat"]), and using the string itself in the set won't track which occurrence was used.

        for(int i=0; i<strs.length; i++) 
        {
            if(set.contains(i)) 
            continue;

            List<String> temp= new ArrayList<>();
            temp.add(strs[i]);
            set.add(i);
            for(int j= i+1; j<strs.length; j++)
            {
                if(!set.contains(j) && isAnagram(strs[i], strs[j]) == true)
                {
                    temp.add(strs[j]);
                    set.add(j);
                }
            }
            result.add(temp);
        }
        return result;       
    }
}