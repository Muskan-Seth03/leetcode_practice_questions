//TC:O(m*n)     n-> total messages  and m-> Avg characters per msg 
//SC: (K)       k->unique sender

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map= new HashMap<>();
     
        for(int  i=0; i<messages.length; i++)
        {
            String sender= senders[i];
            int wordCount= messages[i].split(" ").length;
            map.put(sender, map.getOrDefault(sender, 0) + wordCount);

        }
        String ans="";
        int max_count=0;

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            String sender = entry.getKey();
            int count = entry.getValue();

            if(count> max_count || count== max_count && sender.compareTo(ans)>0 )// person having same no. of words in the msg  encountered , then use compareTo() method   
            {
                max_count= count;
                ans = sender;
            }
        }
        return ans;

    }
}