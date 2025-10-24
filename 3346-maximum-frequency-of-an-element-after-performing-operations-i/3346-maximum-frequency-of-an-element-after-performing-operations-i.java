class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxElement= Integer.MIN_VALUE;
        for(int num: nums)
        {
            if(num > maxElement)
            {
                maxElement= num;
            }
        }
        int[] freq= new int[ maxElement + k + 1];
        for(int num: nums)
        {
            freq[num]++;
        }

        int[] cumFreq= new int[ maxElement + k + 1];
        for(int i=1; i < cumFreq.length; i++)
        {
            cumFreq[i] = cumFreq[i-1] + freq[i];
        }
        // choose target one by one

        int res= 0;
        for(int target=0; target <= maxElement; target++)
        {
            if(freq[target] ==0)
            continue;

            int l= target - k;
            int r= target + k;

            
            int totalCount= cumFreq[r] - (l > 0? cumFreq[l-1] : 0);
            

            int targetCount= cumFreq[target] - (target > 0 ? cumFreq[target - 1] : 0);

            int needConversion= totalCount - targetCount;

            res= Math.max(res,  targetCount + Math.min(needConversion, numOperations)); 
        }
        return res;        
    }
}