class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the  2 d array
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int [] prev=intervals[0];

        List<int []> merged=new ArrayList<>();
        
        for(int i=1;i<intervals.length;i++)
        {
            int [] curr=intervals[i];
            if(prev[1]<curr[0])
            {
                merged.add(prev);
                prev=curr;
            }
            else{
                prev[1]=Math.max(curr[1],prev[1]);
            }
        }
        merged.add(prev);
 
        return merged.toArray(new int [merged.size()][]);
    }
}