class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq= new PriorityQueue<>();
        for(int num: nums)
        {
            pq.offer(num);
        }
        while(pq.size() > k)    // keep size of min-heap fixed at k  
        {
            pq.poll();
        } 
    }
    
    public int add(int val) {
        this.k = k;
        pq.offer(val);

        if(pq.size() > k)
        {
            pq.poll();
        }
        return pq.peek();        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */