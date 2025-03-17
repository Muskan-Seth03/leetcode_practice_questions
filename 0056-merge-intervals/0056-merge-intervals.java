class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
        return new int [0][0];

        //sort the 2 d array
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        // create resultant list (list of array)
        List<int[]> res= new ArrayList<>();
        int [] curr= intervals[0];
        res.add(curr);

        for(int i=1; i<intervals.length; i++)
        {
            int curr_end = curr[1];
            int next_start= intervals[i][0];
            int next_end= intervals[i][1];
            // case of overlapping intervals
            if(curr_end >= next_start)
            {
                curr[1]= Math.max(curr_end, next_end);
            }
            //non-overlapping case  -- keep as it is  
            else
            {
                curr= intervals[i];
                res.add(curr);
            }
        }

        return res.toArray(new int [res.size()][]);
        
    }
}