class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet= new HashSet<>();
        for(String validString : bank)
        {
            bankSet.add(validString);
        }
        if(!bankSet.contains(endGene))
        return -1;

        Queue<String> q= new LinkedList<>();
        q.offer(startGene);

        Set<String> visi= new HashSet<>();
        visi.add(startGene);

        int level= 0;
        while(!q.isEmpty())
        {
            int size= q.size();
            char[] choices= {'A', 'C', 'G', 'T'};

            while(size > 0)
            {
                String start= q.poll();

                if(start.equals(endGene))
                return level; 

                StringBuilder sb= new StringBuilder(start);
                
                for(int i=0; i<8; i++)
                {
                    char origVal = sb.charAt(i);
                    for(int j=0; j<4; j++)
                    {
                        sb.setCharAt(i, choices[j]); 
                        if(bankSet.contains(sb.toString()) && !visi.contains(sb.toString()))
                        {
                            q.offer(sb.toString());
                            visi.add(sb.toString());
                        }
                    }
                    // restore old val
                    sb.setCharAt(i, origVal);
                }
                size--;
            }
            level++;
        }
        return -1;        
    }
}