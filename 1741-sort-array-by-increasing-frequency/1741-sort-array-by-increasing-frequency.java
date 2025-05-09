//TC:O(n + k log k)
//SC:O(n) + O(k) + O(k)    // result arr, hashmap , PQ

class Solution {  
    public int[] frequencySort(int[] nums) {
        int n= nums.length;
        // Count frequency of el
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //min - heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>
        ((a, b) -> 
        {
            int compare = a.getValue() - b.getValue(); // frequency ascending
            if (compare != 0) return compare;
            return b.getKey() - a.getKey();            // value descending if freq equal
        
        });

        pq.addAll(freqMap.entrySet());

        int [] result= new int[n];
        int index=0;      // to iterate through result array for storing the el  
        while(!pq.isEmpty())
        {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int num = entry.getKey();
            int freq = entry.getValue();

          // to store the particula rel in the result array till its freq 
            for(int i=0; i< freq; i++)
            {
                result[index++] = num;
            }
        } 

        return result;
    }
}