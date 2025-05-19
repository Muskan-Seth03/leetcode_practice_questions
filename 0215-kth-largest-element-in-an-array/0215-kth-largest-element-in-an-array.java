class Solution {  // using max-heap  TC:O(n+ klogn)  SC:O(n)
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max-heap

        for(int i=0; i< n; i++)   //O(n)
        {
            pq.offer(nums[i]);
        }
        int j= k-1;
        while(j>0)    // O((k-1).logn)   ==>  O(k.logn)
        {
            pq.poll();
            j--;
        }
        return pq.peek();

    }
}