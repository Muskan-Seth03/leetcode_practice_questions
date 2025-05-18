class Solution {  //TC:O(m + n)   SC:O(n)
    public int canBeTypedWords(String text, String brokenLetters) {
        String []words = text.split(" ");
        HashSet<Character> set= new HashSet<>();
        for(int i= 0; i< brokenLetters.length(); i++)
        {
            set.add(brokenLetters.charAt(i)); 
        }
        int count=0;
        for(String word: words)
        {
            int i=0;
            boolean canType= true; 
            while(i < word.length())
            {
                if(set.contains(word.charAt(i)))
                {
                    canType= false;
                    break;
                }
                //set does'nt contain that character, continue checking for that word
                i++;
            }

            if(canType) count++;
        }
        return count;

    }
}