class Solution {
    public int countHillValley(int[] nums) {
        int n= nums.length;
        int count=0;

        int j=0, k=0;
        for(int i=1; i < n-1; i++)
        {
            //skip consecutive duplicates 
            if(nums[i]== nums[i+1])
            {
                continue;
            }
            j= i+1;
            k= i-1;
            //neighbour on left 
            while(k>=0 && nums[i]== nums[k])
            {
                k--;
            }
            // neighbour on right
            while( j<n && nums[i] == nums[j])
            {
                j++;
            }

    if(k>=0 && j<n)
    {
        if(nums[i] > nums[j] && nums[i] > nums[k] || nums[i] < nums[j] && nums[i] < nums[k])
        {
            count++;
        }
    } 
        }
        return count;        
    }
}