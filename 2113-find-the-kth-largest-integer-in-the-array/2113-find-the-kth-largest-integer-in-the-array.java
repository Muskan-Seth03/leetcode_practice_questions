class Solution {  // better approach (using PQ)  TC:O(n log k)  SC:O(k)
    public String kthLargestNumber(String[] nums, int k) {
        int n= nums.length;
        PriorityQueue<String> pq= new PriorityQueue<>
        ((a,b)->
            {
                if(a.length() != b.length())   // check length
                return a.length() - b.length();
                else                           // equal length, compare lexicographically
                return a.compareTo(b);
            }
        );
        for(String num: nums)
        {
            pq.offer(num);
        }
        while(pq.size() > k)
        pq.poll();

        return pq.peek();
    }
}