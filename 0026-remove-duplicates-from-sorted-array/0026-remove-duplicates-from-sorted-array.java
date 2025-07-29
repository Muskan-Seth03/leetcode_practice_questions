// stay at first el and find the next different el through j and once we found the different el replace i+1 th el with different el 

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j= 1; j<nums.length; j++)
        {
            if(nums[i] != nums[j])
            {
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
        
        
    }
}

  