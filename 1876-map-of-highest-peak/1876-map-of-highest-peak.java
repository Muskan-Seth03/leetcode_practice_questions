 class Pair{       // using bfs   TC:O(m*n*4)  SC:O(m*n) + O(m*n) for queue and height matrix

    int row;
    int col;
    Pair(int row, int col)
    {
        this.row= row;
        this.col= col;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m= isWater.length;
        int n= isWater[0].length;

        int height[][]= new int [m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<m ;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isWater[i][j]==1)   // if water , then push wtaer into queue 
                {        
                    height[i][j]= 0;
                    q.offer(new Pair(i,j));    // push water cell into the queue
                }
                else
                {
                    height[i][j]=-1;  // if land encountered 
                }
            }
        }
        int dr[]={-1,0,1,0};
        int dc[]= {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair it= q.poll();
            int r= it.row;
            int c= it.col;

            for(int i=0; i<4; i++)
            {
                int new_r= r + dr[i];
                int new_c= c+ dc[i];

                if(new_r>=0 && new_r <m && new_c>=0 && new_c<n && height[new_r][new_c]==-1)
                {
                    height[new_r][new_c]= height[r][c] +1;  // increase height by factor of 1 from its parent
                    q.offer(new Pair(new_r, new_c));
                }
            }
        }
    return height;
    }
   
}
