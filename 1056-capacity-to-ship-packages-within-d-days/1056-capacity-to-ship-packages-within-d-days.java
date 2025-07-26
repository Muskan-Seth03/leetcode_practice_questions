//binary search approach  TC:O(n * log sum(arr)- max(arr) + 1)   SC:O(1)
import java.util.*;
class Solution {
    public static boolean ispossible(int mid, int []weights, int days)
    {
        int sum=0;
        int daysRequired=1;
        int n= weights.length;
        for(int i=0; i<n; i++)
        {
            if(sum + weights[i] <= mid)
            {
                sum+=weights[i];
            }
            else
            {
                daysRequired++;
                sum=weights[i];
            }
        }
        return (daysRequired <= days);
    }
    public int shipWithinDays(int[] weights, int days) {
        int low= Arrays.stream(weights).max().getAsInt();
        int high= Arrays.stream(weights).sum();

        while(low <= high)
        {
            int mid= low + (high-low)/2;
            if(ispossible(mid, weights, days))
            {
                high= mid-1;
            }
            else
            low= mid+1;

        }
        return low;
    }
}