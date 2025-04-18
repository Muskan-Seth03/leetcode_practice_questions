class Solution {
    int m, n;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;
    List<int[]> borders = new ArrayList<>();

    public void dfs(int[][] grid, int r, int c, int color, int origColor) {
        visited[r][c] = true;
        boolean isBorder = false;

        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != origColor) {
                isBorder = true;
            } else if (!visited[nr][nc]) {
                dfs(grid, nr, nc, color, origColor);
            }
        }

        if (isBorder) {
            borders.add(new int[]{r, c});
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int origColor = grid[row][col];

        dfs(grid, row, col, color, origColor);

        for (int[] cell : borders) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }
}
