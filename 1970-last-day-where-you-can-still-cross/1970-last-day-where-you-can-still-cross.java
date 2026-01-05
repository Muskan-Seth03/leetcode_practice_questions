// using bfs 
// TC: O(log n * row * col)
// SC: O(row * col)
class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first= first;
        this.second= second;
    }
}
class Solution {
    private boolean bfs(int i, int j, int[][]grid)
    {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        grid[i][j]= 1;

        int[] dir_r= {-1, 0, 1, 0};
        int[] dir_c= {0, 1, 0, -1};
        
        while(!q.isEmpty())
        {
            Pair temp= q.poll();
            int row= temp.first;
            int col= temp.second;

            if(row == grid.length - 1)
            return true;

            for(int k=0; k<4; k++)
            {
                int new_r= row + dir_r[k];
                int new_c= col + dir_c[k];

                if(new_r >= 0 && new_c >=0 && new_r < grid.length && new_c < grid[0].length && grid[new_r][new_c] == 0)
                {
                    q.offer(new Pair(new_r, new_c));
                    grid[new_r][new_c] = 1;
                }
            }
        }
        return false;
       
    }

    private boolean canCross(int[][]cells, int mid, int row, int col)
    {
        // for every mid value
        // create grid filled with water in cells from 0 to mid index in cells array
        int[][] grid= new int[row][col];
        for(int i=0; i <= mid; i++)
        {
            int x= cells[i][0] - 1;
            int y= cells[i][1] - 1;

            grid[x][y]= 1; 
        }
        // apply dfs
        for(int j=0; j<col; j++)
        {
            if(grid[0][j] == 0 && bfs(0, j, grid) == true)
            {
                return true;
            }
        }
        return false;
    } 
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0;
        int r = cells.length;

        int lastDay= 0;
        while (l <= r) 
        {
            int mid= l + (r-l)/2;
            if(canCross(cells, mid, row, col))
            {
                l= mid + 1;
                lastDay= mid + 1;
            }
            else
            {
                r= mid - 1;
            }
        }
        return lastDay;
    }
}
