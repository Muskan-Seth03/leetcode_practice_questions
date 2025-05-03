class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int k= n/2;
        
        //intially

        int element=0;
        int count=0;
        //1 st pass
        for(int i=0; i<n; i++)
        {
            if(count==0)
            {
                element= nums[i];
                count=1;

            }
            else if (element == nums[i])
            count++;
            else
            count--;

        }
        //expected majority el found
        //2nd pass  ---> check if expected el is majority or not 
        int count1=0;
        for(int i=0; i<n; i++)
        {
            if(element== nums[i])
            count1++;
        }
        if(count1> k)
        return element;
        else
        return -1;

    }
}