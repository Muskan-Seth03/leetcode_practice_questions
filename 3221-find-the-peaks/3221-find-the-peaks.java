class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        int ind= -1;
        List<Integer> list= new ArrayList<>();
        for(int i=1; i< mountain.length-1; i++)
        {
            if(mountain[i]> mountain[i-1] && mountain[i] > mountain[i+1])
            {
                ind= i;
                list.add(ind);
            }
        }
        return list;        
    }
}