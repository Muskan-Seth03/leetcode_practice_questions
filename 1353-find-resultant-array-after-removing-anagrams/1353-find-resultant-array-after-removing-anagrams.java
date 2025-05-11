// TC:O(n * m) ...for for n words and m is the avg length of word
// SC:O(n)

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

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for(int i=1; i< words.length; i++)
        {
            if(!isAnagram(words[i], result.get(result.size()-1)))
            {
                result.add(words[i]);
            }
        }

        return result;
    }
}