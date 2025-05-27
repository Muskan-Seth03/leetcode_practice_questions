//TC: O(n log k) + O(k log k) => O(n log k)   just O(n log k) if k is small relative to n.
//SC: O(n + k)   hashmap and resultant list
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n= words.length;
        Map<String, Integer> map= new HashMap<>();
        for(String word: words)
        map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> pq= new PriorityQueue<>
        ((a,b)-> 
            {
                int freqCompare= a.getValue().compareTo(b.getValue());
                if(freqCompare != 0)
                return freqCompare;
                else
                return b.getKey().compareTo(a.getKey());
            }
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);      // worst case O(n logk)
            if (pq.size() > k)
            {
                pq.poll();
            }  
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty())
        {
            list.add(pq.poll().getKey());    // O(k logk)
        }
        Collections.reverse(list);      // O(k)

        return list;
    }
}