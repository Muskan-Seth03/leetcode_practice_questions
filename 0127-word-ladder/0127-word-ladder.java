class Pair{
String first; 
int second;
    Pair(String first, int second)
    {
        this.first= first;
        this.second= second;
    }
}
class Solution { // using bfs traversal
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        
        Set<String> set= new HashSet<>();
        for(String s: wordList)
        {
            set.add(s);
        }
        // we have to remove the startWord if present in wordList 
        //otherwise startWord will be counted twice in the sequence.
        
        while(!q.isEmpty())
        {
            Pair it= q.poll();
            String word= it.first;
            int level= it.second;
            
            if(word.equals(endWord)==true) return level;
            
            char replacedArray[]= word.toCharArray();
            for( int i=0; i<word.length(); i++)
            {
                char origChar= replacedArray[i];
                //replace this character with a , b, c, ....,z
                for(char ch='a'; ch<='z'; ch++)
                {
                    replacedArray[i]= ch;
                    String replacedWord = new String(replacedArray);
                    
                    if(set.contains(replacedWord))
                    {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, level+1));
                    }
                    
                }
                // RESET to original for next index
                replacedArray[i]=origChar;
            }
            
        }
        // if there is no possible transformation
        return 0;
        
    }
}