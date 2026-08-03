class Solution {
    private int n;
    private Integer[] dp;

    private int solve(int[] stoneValue, int i) {
        // Base case
        if (i == n) {
            return 0;
        }

        // Memoization
        if (dp[i] != null) {
            return dp[i];
        }

        // Take 1 stone
        int ans = stoneValue[i] - solve(stoneValue, i + 1);

        // Take 2 stones
        if (i + 1 < n) {
            ans = Math.max(ans,
                    stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i + 2));
        }

        // Take 3 stones
        if (i + 2 < n) {
            ans = Math.max(ans,
                    stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(stoneValue, i + 3));
        }

        return dp[i] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new Integer[n];

        int diff = solve(stoneValue, 0);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}