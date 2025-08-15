// approach 2
// TC: O(n) SC:O(1)
class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int left=0;
        int right= n-1;

        int res=0;

        while(left < right)
        {
            res= Math.max(res, Math.min(height[left], height[right]) * (right - left));
            
            //shift the min pointer
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
           
        }
        return res;       
    }
}