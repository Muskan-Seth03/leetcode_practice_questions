class Solution {   // printing LIS approach 
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[]dp= new int[n];
        int[]hash= new int[n];

        Arrays.fill(dp, 1);
        int maxi=1;
        int last_index=0;
        for(int ind=0; ind<=n-1; ind++)
        {
            hash[ind]=ind;
            for(int prev=0; prev<ind; prev++)
            {
                if(nums[prev] < nums[ind]  && (1 + dp[prev]) > dp[ind])
                {
                    hash[ind]= prev;
                    dp[ind]= 1 + dp[prev];
                }
            }
            if(dp[ind]> maxi)
            {
                maxi= dp[ind];
                last_index=ind;
            }
        }
        ArrayList<Integer> list= new ArrayList<>();
        list.add(nums[last_index]);
        while(hash[last_index]!=last_index)
        {
            last_index=hash[last_index];
            list.add(nums[last_index]);
        }
        Collections.reverse(list);
        System.out.println(list);
        return maxi;

    }
}