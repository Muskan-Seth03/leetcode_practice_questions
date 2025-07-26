//binary search approach  TC:O(n * log max(arr)+1)   SC:O(1)
import java.util.*;
class Solution {
    public static int f(int mid, int[] nums, int threshold)
    {
        int sum=0;
        for(int i=0; i<nums.length; i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        // base case
        if(nums.length > threshold)
        return -1;

        //divisor can be 1, 2, 3, ...max(arr)
        int low= 1;
        int high= Arrays.stream(nums).max().getAsInt();
        int ans= 0;
        while(low<= high)
        {
            int mid= low + (high-low)/2;
            int sum=f(mid, nums, threshold);
            if(sum<= threshold)
            {
                ans=mid;
                high= mid-1;
            }
            else
            low= mid+1;
        }
        return low;
    }
}