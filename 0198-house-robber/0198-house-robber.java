class Solution { //Tabulation   TC: O(2^n)*O(1)

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int rob = nums[i] + dp[i + 2];
            int not_rob =dp[i + 1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[0];
    }
}
