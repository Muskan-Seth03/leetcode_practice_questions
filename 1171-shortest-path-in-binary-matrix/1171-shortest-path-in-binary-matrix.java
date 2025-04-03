class Tuple{
    int dis;
    int row;
    int col;
    Tuple(int dis, int row, int col)
    {
        this.dis= dis;
        this.row= row;
        this.col= col;
        
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;  // for rows and cols

        // Edge Case: if the source is only the destination.
        if(n==1 && grid[0][0]==1) return -1;
        if(n==1 && grid[0][0]==0) return 1;
        // if  first cell is blocked then no further path
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;

        Queue<Tuple> q= new LinkedList<>();
        
        int dist[][]= new int [n][n];
        // initialise dist array 
        for(int row[]: dist)
        {
            Arrays.fill(row, (int)(1e9));
        }
        int ir= 0;
        int ic= 0;
        
        dist[ir][ic]=0;
        
        q.offer(new Tuple(0, ir, ic));
        
        while(!q.isEmpty())
        {
            Tuple it= q.poll();
            int dis= it.dis;
            int r= it.row;
            int c= it.col;
            
            int dr[] = {-1, -1, -1,  0,  0,  1,  1,  1};
            int dc[] = {-1,  0,  1, -1,  1, -1,  0,  1};

            
            for(int i=0; i<8; i++)
            {
                int fr= r+ dr[i];
                int fc= c+ dc[i];
                
                if(fr>=0 && fr<n && fc>=0 && fc<n && grid[fr][fc]== 0 && 
                    dis + 1 < dist[fr][fc])
                {
                    dist[fr][fc]= dis +1;
                    q.offer(new Tuple(dist[fr][fc], fr, fc));
                
                    if(fr == n-1 && fc == n-1)
                    {
                         return dist[fr][fc]  + 1 ;
                    }
                }
            }
            
            
        }
        return -1;
    }
}
