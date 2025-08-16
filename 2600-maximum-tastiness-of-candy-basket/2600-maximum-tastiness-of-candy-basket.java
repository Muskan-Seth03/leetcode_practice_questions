// binary search on answers 
// TC: O(n log n)  SC: O(1)
import java.util.Arrays;
class Solution {
    public boolean canMakeBasket(int mid, int[] price, int k)
    {
        int n= price.length;
        int count=1;
        int lastPicked= 0;
        for(int i=1; i<n; i++)
        {
            if(price[i] - price[lastPicked] >= mid)
            {
                lastPicked= i;
                count++;
            }
        }
        if(count >= k)
        {
            return true;
        }
        else
        return false;
    }

    public int maximumTastiness(int[] price, int k) {
        int n= price.length;
        Arrays.sort(price);
        
        int low= 1;
        int high = price[price.length - 1] - price[0]; // tighter upper bound
        int ans=0;
        while(low<= high)
        {
            int mid= low +(high - low)/2;
            if(canMakeBasket(mid, price, k))
            {
                ans=mid;
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }
        }
        return ans; 
    }
}