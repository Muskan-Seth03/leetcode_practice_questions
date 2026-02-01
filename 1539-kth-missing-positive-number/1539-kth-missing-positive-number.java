// TC: O(n)  SC: O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
            for(int num : arr)
            {
                if(num <= k)
                {
                    k++;
                }
                else
                {
                    break;       // further numbers will be greater 
                }
            }
            return k;
    }
}