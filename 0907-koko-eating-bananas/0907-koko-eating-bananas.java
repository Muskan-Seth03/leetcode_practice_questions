// binary search
//TC: O(n * log max(arr))    SC: O(1)
import java.util.*;
class Solution { 
    public static long f(int[]piles, int mid)
    {
        long total_hr= 0;
        for(int i=0; i<piles.length; i++)
        {
            total_hr+= (int)Math.ceil((double)piles[i]/(double)mid);
        }
        return total_hr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low= 1;
        int high= Arrays.stream(piles).max().getAsInt();
        int ans= 0;
        while(low<=high)
        {
            int  mid= low + (high-low)/2;
            long total_hr= f(piles,  mid);
            if(total_hr <=h)
            {
                ans= mid;
                high= mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}