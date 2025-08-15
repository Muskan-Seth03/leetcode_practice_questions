//approach 2 using 2 pointers : left and right
// TC: O(n)  SC:O(1)
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int  n= height.length;
         
        int left=0;
        int right= n-1;

        int maxLeft= height[left];
        int maxRight= height[right];
        int res=0;
        while(left < right)
        {
            //shift the min pointer
            if(maxLeft < maxRight)
            {
                left++;
                if(Math.min(maxLeft, maxRight) - height[left] > 0)
                {
                    res+= Math.min(maxLeft, maxRight) - height[left];
                }
                maxLeft= Math.max(maxLeft, height[left]);
            }
            else
            {
                right--;
                if(Math.min(maxLeft, maxRight) - height[right] > 0)
                {
                    res+= Math.min(maxLeft, maxRight) - height[right];
                }
                maxRight= Math.max(maxRight, height[right]);
            }
           
        }
        return res;       
    }
}