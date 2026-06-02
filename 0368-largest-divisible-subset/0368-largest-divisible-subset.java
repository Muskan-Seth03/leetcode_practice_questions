// tabulation approach
// TC: O(n*n)  SC: O(n)
class Solution {
    List<Integer> res;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        res = new ArrayList<>();
        // sort the array
        Arrays.sort(nums);
        
        int maxL = 1;
        int[] dpSubset = new int[n];
        int[] prevInd = new int[n];

        Arrays.fill(dpSubset, 1);
        Arrays.fill(prevInd, -1);

        int ind = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[i] % nums[j] == 0 && dpSubset[j] + 1 > dpSubset[i])
                {
                    dpSubset[i] = dpSubset[j] + 1;
                    prevInd[i] = j;
                }
                if(dpSubset[i] > maxL)
                {
                    maxL = dpSubset[i];
                    ind = i;
                }
            }
        }
        
        while(ind != -1)
        {
            res.add(nums[ind]);
            ind = prevInd[ind];
        }
        Collections.reverse(res);
        return res;
    }
}