// TC: O(n) SC: O(1)
// [3]   only 1 subarray
// [3, 2]  ......[3] already added ....new addition [2], [3, 2]  (2 new subarrays)
// [3, 2, 1].....[3], [2], [3, 2] already added...new addition [1], [2, 1], [3, 2, 1] (3 new subarrays)

class Solution {
    public long getDescentPeriods(int[] prices) {
        int n= prices.length;
        long res= 1;
        long count= 1;

        for(int i=1; i<n; i++){
            if(prices[i-1] - prices[i] == 1){
                count++;
            }
            else{
                count = 1;
            }
            res +=  count;
        }
        return res;
    }
}