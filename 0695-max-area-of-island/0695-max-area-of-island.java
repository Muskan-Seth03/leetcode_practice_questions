class Pair{     // using bfs  TC:O(m*n)  SC:O(m*n)
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first= first;
        this.second= second;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int max_area=0;
        int count=0;

        int visi[][]= new int [m][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visi[i][j] == 0 && grid[i][j]==1) {
                    count++;
                    int area=bfs(grid, i, j, visi);
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

    private static int bfs(int[][] grid, int i, int j, int [][]visi) {
        int m = grid.length, n = grid[0].length;
        
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(i, j));
        visi[i][j]=1;

        int area=1;
        int dir_r[]= {0, -1, 0, 1};
        int dir_c[]= {-1, 0, 1, 0};
        
        while(!q.isEmpty())
        {
            Pair it= q.poll();
            int row= it.first;
            int col= it.second;
            
            for(int k=0; k<4; k++)
            {
                int new_r= row + dir_r[k];
                int new_c= col + dir_c[k];

                if( new_r>=0 && new_r <m && new_c>=0 && new_c<n && grid[new_r][new_c]==1 && visi[new_r][new_c]== 0)
                {
                    area++;
                    q.offer(new Pair(new_r, new_c));
                    visi[new_r][new_c]=1;
                }

            }
        }
        return area;

    }
}

            
