//TC: O(m)
//SC: O(1)
class Solution {   
    public int leastInterval(char[] tasks, int n) {
        int m= tasks.length;
        int frequency []= new int [26];
        int time=0;
        // create a max-heap becoz we want to process most frequent el first.
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(char task: tasks)
        {
            frequency[task - 'A']++;  //O(m) ==> O(1)
        }
        for(int i=0; i< 26; i++)     //O(26) ==> O(1)
        {
            if(frequency[i] > 0)
            pq.offer(frequency[i]);   //Max 26 characters (A–Z): O(26 log 26) → O(1)
        }
        List<Integer> temp= new ArrayList<>();
        while(!pq.isEmpty())   // O(m)
        {
            for(int i=1; i<=n+1; i++)        
            {
                if(!pq.isEmpty())
                {
                    int freq= pq.poll();   //O(26 log 26)  ==> O(1)
                    freq--;
                    temp.add(freq);   //O(1)
                }
            }
            //after looping n+1 times in 1 iteration 
            for(int i=0; i < temp.size(); i++)
            {
                if(temp.get(i) > 0)         // dont put if freq is 0
                pq.offer(temp.get(i));      //O(log k)
            }
            // what if all the freq is zero , then we have to add temp.size() to time ...as it denotes char whose work is completed and they have got 0 freq.
            if(pq.isEmpty())
            time+= temp.size(); 
            else
            time+= n + 1;

            temp.clear();
        }
        return time;
    }
}