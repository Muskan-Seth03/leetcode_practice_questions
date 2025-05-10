class Solution {  //TC:O(n)  SC:(1)
    public int[] numberOfPairs(int[] nums) {
        int[] freq=new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int rem_count=0;
        int pair_count=0;
        for(int i=0;i<freq.length;i++)
        {
            rem_count += freq[i] % 2 == 0 ? 0 : 1 ;  
            pair_count += (freq[i])/2;
        }
        return new int[]{ pair_count, rem_count };
       
    }
}