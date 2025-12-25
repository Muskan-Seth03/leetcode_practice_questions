// using heap (PQ) approach 
// TC: O(n log n) for insertion in heap + O(k log n) popping k times  
// SC: O(n) for heap
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n= happiness.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i=0; i<n; i++)
        pq.offer(happiness[i]);

        int counter=0;
        long sum=0;
        while(!pq.isEmpty() && k > 0)
        {
            int el= pq.poll();
            sum += (el - counter) > 0 ? el - counter : 0;
            counter++;
            k--;
        }
        return sum;
    }
}