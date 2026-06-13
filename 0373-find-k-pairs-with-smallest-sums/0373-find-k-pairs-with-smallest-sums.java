// TC: O(m * n * log k)  SC: O(k)
// standard heap problem (brute force)
class Pair implements Comparable<Pair>{
    int sum;
    int[] arr;

    Pair(int sum , int[] arr)
    {
        this.sum = sum;
        this.arr = arr;
    }
    @Override
    public int compareTo(Pair other)
    {
        return Integer.compare(this.sum, other.sum);
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int m = nums1.length;
        int n = nums2.length;
        int sum = 0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                sum = nums1[i] + nums2[j];

                if(pq.size() < k)
                {
                    pq.offer(new Pair(sum, new int[]{i, j}));
                }
                else if(pq.peek().sum > sum)
                {
                    pq.poll();
                    pq.offer(new Pair(sum, new int[]{i, j}));
                }
                else
                {
                    break;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();

       
        while(!pq.isEmpty())
        {
            List<Integer> list = new ArrayList<>();

            Pair temp = pq.poll();
            int[] curr = temp.arr;
            int i= curr[0];
            int j= curr[1];
            
            list.add(nums1[i]);
            list.add(nums2[j]);

            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}