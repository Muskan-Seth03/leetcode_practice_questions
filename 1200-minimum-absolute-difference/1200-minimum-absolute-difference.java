// TC: O(n log n)  SC: O(n)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff= Integer.MAX_VALUE;
        // find minimum difference
        for(int i=1; i<n; i++)
        {
            minDiff= Math.min(minDiff, arr[i] - arr[i-1]);
        }
        // put the pairs having the minDiff in res list
        for(int i=1; i<n; i++)
        {
            if(arr[i] - arr[i-1] == minDiff)
            {
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return res;
    }
}