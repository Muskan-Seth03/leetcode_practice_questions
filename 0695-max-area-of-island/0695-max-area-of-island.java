class Solution {  // iterative dfs  TC:O(m*n)  SC:O(m*n)
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int max_area=0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    int area=dfs(grid, i, j);
                    max_area= Math.max(max_area, area);
                }
            }
        }

        if(count==0)  // no island present
        {
            return 0;
        }
        return max_area;
        
    }

    private static int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // boundary and water check 
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        Stack<int[]> s= new Stack<>();
        s.push(new int[]{i, j});

        grid[i][j] = 0;   //mark it as visited
        
        int dir_r[]= {0, -1, 0, 1};
        int dir_c[]= {-1, 0, 1, 0};
        
        int area=1;
        while(!s.isEmpty())
        {
            int [] it= s.pop();
            int row= it[0];
            int col= it[1];

            for(int k=0; k<4; k++)
            {
                int new_r= row + dir_r[k];
                int new_c= col + dir_c[k];

                if( new_r>=0 && new_r <m && new_c>=0 && new_c<n && grid[new_r][new_c]== 1)
                {
                    area++;
                    s.push(new int []{new_r, new_c});
                    // mark neighbour as vsited
                    grid[new_r][new_c]=0;
                }

            }

        }

        return area;
    }
}
