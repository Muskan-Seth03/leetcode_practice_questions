import java.util.Stack;  // stack+ dfs  TC:O(m * n)  SC:O(min(m, n))
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        grid[i][j] = '0'; // Mark as visited

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] =='1')          
        
        {
            stack.push(new int[]{newX, newY});
                grid[newX][newY] = '0'; // Mark as visited
        }

            }
        }
    }
}
