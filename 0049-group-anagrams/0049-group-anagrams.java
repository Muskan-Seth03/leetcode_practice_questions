// without sorting
// TC: O(n* (k + 26))    SC: O(n)
class Solution {
    int[] freq;
    public String generateWord(String str)
    {
        for(int i=0; i< str.length(); i++)
        {
            freq[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < 26; i++)
        {
            while(freq[i] != 0)
            {
                sb.append((char)(i + 'a'));
                freq[i]--;
            }
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n= strs.length;
        freq = new int[26];
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs)
        {
            String sortedWord = generateWord(str);
            if(!map.containsKey(sortedWord))
            {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(str);
        }
        return new ArrayList<>(map.values());
    }
}