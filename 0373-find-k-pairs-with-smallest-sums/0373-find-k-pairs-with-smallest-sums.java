// TC: O(k log k)  SC: O(k)
// optimal approach (PQ + set)
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
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> res = new ArrayList<>();

        if(m == 0 || n == 0 || k == 0)
        {
            return res;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        Set<String> visi = new HashSet<>();

        int sum = nums1[0] + nums2[0];

        pq.offer(new Pair(sum, new int[]{0, 0}));
        visi.add("0,0");
       
        while(k-- > 0 && !pq.isEmpty())
        {
            List<Integer> list = new ArrayList<>();

            Pair temp = pq.poll();
            int[] curr = temp.arr;
            int i = curr[0];
            int j = curr[1];

            list.add(nums1[i]);
            list.add(nums2[j]);

            res.add(list);

            // out of bound check + duplicate check   for (i+1, j)
            String down = (i + 1) + "," + j;
            
            if(i+1 < m && !visi.contains(down))
            {
                pq.offer(new Pair(nums1[i+1] + nums2[j], new int[]{i+1, j}));

                visi.add(down);
            }

            // out of bound check + duplicate check   for (i, j+1)
            String right = i + "," + (j + 1);
            
            if(j+1 < n && !visi.contains(right))
            {
                pq.offer(new Pair(nums1[i] + nums2[j+1], new int[]{i, j+1}));
                
                visi.add(right);
            }
        }
        return res;
    }
}
