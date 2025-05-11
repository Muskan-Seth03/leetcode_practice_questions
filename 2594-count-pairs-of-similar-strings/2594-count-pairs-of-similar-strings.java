//Set.equals() checks:

//Both sets contain the same number of elements.

//Every element of one set is also in the other.

class Solution {
    public int similarPairs(String[] words) {
        int n= words.length;
        int count=0;
        for(int i=0; i< words.length - 1 ; i++)
        {
            HashSet<Character> set1 = new HashSet<>();
            char[] wordArray = words[i].toCharArray();
            for (char c : words[i].toCharArray()) 
            {
                set1.add(c);
            }
            for (int j = i + 1; j < n; j++) 
            {
                HashSet<Character> set2 = new HashSet<>();
                for (char c : words[j].toCharArray()) 
                {
                    set2.add(c);
                }

                if (set1.equals(set2)) 
                {
                    count++;
                }

            }
        }
        return count;
    }
}
        
             