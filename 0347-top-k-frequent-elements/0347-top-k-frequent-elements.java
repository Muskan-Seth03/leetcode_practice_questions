//TC :O(n) hashmap + unique el (approx n) PQ add/pop O(n log k) maintain size k 
//                                                                       + extract O(k log k)  
//  total TC:O(n log k)
//SC: O(n) + O(k) => O(n +k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int num: nums)
        map.put(num, map.getOrDefault(num, 0) + 1);

        // find the top k elements in freq 
        // maintain pq size of k

        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>
        ((a,b)-> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.offer(entry);
            if(pq.size() > k)
            pq.poll();   // remove lowest frequency
        }
        // return the key value of frequent element 
        int i=0;
        int res[]= new int[k];
        while(!pq.isEmpty())
        {
            res[i]= pq.poll().getKey();
            i++;
        }
        return res;    
    }
}