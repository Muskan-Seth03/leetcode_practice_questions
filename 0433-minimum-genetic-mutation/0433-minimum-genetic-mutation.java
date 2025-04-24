class Pair{     // using bfs approach
String first; 
int second;
    Pair(String first, int second)
    {
        this.first= first;
        this.second= second;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
     
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(startGene, 0));
        
        Set<String> set= new HashSet<>();
        for(String s: bank)
        {
            set.add(s);
        }
        // we have to remove the startWord if present in wordList 
        //otherwise startWord will be counted twice in the sequence.
        char choices[]= {'A','C','G','T'};

        while(!q.isEmpty())
        {
            Pair it= q.poll();
            String word= it.first;
            int level= it.second;
            
            if(word.equals(endGene)==true) return level;
            
            char replacedArray[]= word.toCharArray();
            for( int i=0; i<word.length(); i++)
            {
                char origChar= replacedArray[i];
                //replace this character with a , b, c, ....,z
                for(char ch: choices)
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
        return -1;
        
    }
}