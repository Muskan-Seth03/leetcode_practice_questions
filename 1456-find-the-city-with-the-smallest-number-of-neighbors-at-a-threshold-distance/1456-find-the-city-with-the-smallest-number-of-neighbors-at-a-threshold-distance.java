class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) (1e8));
            dist[i][i] = 0;
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
            }
        }
        //multisource path via 0, 1, 2, 3....
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) 
                {
                    if (dist[i][k] != (int) (1e8) && dist[k][j] != (int) (1e8))
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int minCity = -1;
        for (int i = 0; i < n; i++) 
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if ( i!=j && dist[i][j] <= distanceThreshold) 
                {
                    count++;
                }
            }
            // no need to check for max 
            // cities are checked in increasing order of their number.
            if (count <= minCount) {
                minCity = i;
                minCount = count;
            }
        }
    
        return minCity;
    }
}
