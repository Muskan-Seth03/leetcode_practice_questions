// TC: O(n log n)  SC: O(1)
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
      
        for (int i = n - 1; i >= 0; i--) {
            sum += cost[i]; // Buy the first candy
            i--;
            if (i >= 0)
            sum += cost[i]; // Buy the second candy 
            i--; // Skip the third (free) candy
        }
        return sum;
    }
}