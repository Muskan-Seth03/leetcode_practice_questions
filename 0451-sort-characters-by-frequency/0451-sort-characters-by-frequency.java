//TC: O(n + k log k)  traversal for hashmap creation, k unique character add in queue(k log k)
//////// worst case : all char are unique  O(n log n)
//SC: O(n + k +  k)   ~ o(n)     /...k unique entry in hashmap and pq  + string builder

class Solution {
    public String frequencySort(String s) {
        // Count frequency of characters
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq= new PriorityQueue<>
        ((a,b)-> b.getValue()  -  a.getValue());

        pq.addAll(freqMap.entrySet());

        // build the resultant string
        StringBuilder result=  new StringBuilder();
        while(!pq.isEmpty())
        {
            Map.Entry<Character, Integer> entry = pq.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            for(int i=0; i< freq; i++)
            {
                result.append(ch);
            }
        } 

        return result.toString();

    }
}