// using QuickeSelect ==>  QuickSelect is designed to find the Kth smallest element.
// we convert the Kth largest to the (n - k)th smallest.
// TC:O(n)  SC:O(1)
import java.util.Random;
class Solution {
    public static String quickSelect(String nums[], int left, int right, int k)
    {
        if(left== right)
        return nums[left];

        Random rand= new Random();
        while(left<= right)
        {
            int pivotIndex= rand.nextInt(right - left + 1) + left;
            int newPivotIndex= partition(nums, left, right, pivotIndex);

            if(newPivotIndex == k) 
            return nums[newPivotIndex];
            else if( newPivotIndex > k)
            return quickSelect(nums, left, newPivotIndex - 1, k);
            else
            return quickSelect(nums, newPivotIndex + 1, right, k);
        }
        return "";
    } 
    public static int partition(String nums[] , int left, int right, int pivotIndex)
    {
        int j=left;
        String pivotValue= nums[pivotIndex];
        swap(nums, pivotIndex, right);
        for(int i=left; i<right; i++)
        {
            if(compare(nums[i], pivotValue) < 0)
            {
                swap(nums, i, j);
                j++;
            }
        
        }
        swap(nums, j, right);

        return j;

    }
    private static int compare(String a, String b) {
        if (a.length() != b.length())
            return a.length() - b.length();
        return a.compareTo(b);
    }
    private static void swap(String nums[], int i, int j)
    {
        String ptr= nums[i];
        nums[i]= nums[j];
        nums[j]= ptr;
    }

    public String kthLargestNumber(String[] nums, int k) {
        int n= nums.length;
        int left= 0;
        int right= n-1;
        return quickSelect(nums, left, right, n-k);
    }
}