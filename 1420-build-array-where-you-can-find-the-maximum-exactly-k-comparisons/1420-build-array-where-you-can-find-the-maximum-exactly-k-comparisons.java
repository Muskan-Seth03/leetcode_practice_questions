import java.util.*;

class Solution {
    int N, M, K;
    int MOD = 1_000_000_007;

    int[][][] t;

    public int solve(int ind, int searchCost, int maxSoFar) {

        if (searchCost > K) return 0;

        if (ind == N) {
            return (searchCost == K) ? 1 : 0;
        }

        if (t[ind][searchCost][maxSoFar] != -1)
            return t[ind][searchCost][maxSoFar];

        int res = 0;

        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                res = (res + solve(ind + 1, searchCost + 1, i)) % MOD;
            } else {
                res = (res + solve(ind + 1, searchCost, maxSoFar)) % MOD;
            }
        }

        return t[ind][searchCost][maxSoFar] = res;
    }

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        t = new int[n + 1][k + 1][m + 1];

        for (int[][] a : t) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(0, 0, 0);
    }
}