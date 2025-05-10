class Solution {   // TC:O(n)  SC:O(1)
    public int mostFrequent(int[] nums, int key) {
        int n= nums.length;
        int[] freq=new int[1001];
        Arrays.fill(freq, 0);

        for(int i=0; i < n-1 ; i++)
        {
            if(nums[i]==key)
            {
                freq[nums[i+1]]++;
            }
        }

        int max_freq=0;
        int target=0;
        for(int i=0; i < 1001 ; i++)
        {
            if( freq[i]> max_freq)
            {
                max_freq= freq[i];
                target= i;
            }
        }
        return target;
    
    }
}