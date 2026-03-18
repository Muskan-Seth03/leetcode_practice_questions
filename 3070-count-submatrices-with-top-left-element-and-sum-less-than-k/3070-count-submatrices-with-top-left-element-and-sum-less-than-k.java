class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;

        long[] cols = new long[c];
        int res = 0;

        for (int i = 0; i < r; i++) {
            long rowSum = 0;
            for (int j = 0; j < c; j++) {
                cols[j] += grid[i][j];
                rowSum += cols[j];
                if (rowSum <= k)
                    res++;
            }
        }

        return res;
    }
}