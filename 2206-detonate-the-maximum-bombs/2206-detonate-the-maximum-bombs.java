class Solution { // using dfs TC:O(n*n)+O(V+E)
//  SC:O(n)+O(n*n)+ O(n) visi+ adjList+ recursive stack 

    public static int dfs(int node, boolean[]visi, List<List<Integer>> adjList)
    {
        // mark the node visited 
        visi[node]=true;
        int count=1;  // if no neighbour , then count itself 
        for(int neighbour : adjList.get(node))
        {
            if(visi[neighbour]!=true)
            {
                count+=dfs(neighbour, visi, adjList);
            }
        }
        return count;
    } 

    public int maximumDetonation(int[][] bombs) {
        int n= bombs.length;

        List<List<Integer>> adjList= new  ArrayList<>();
        // create adjacency list
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        } 

        for(int i =0; i<n; i++)   // bomb i is the exploding bomb 
        {   
            int []curr= bombs[i];
            for(int j= 0; j<n; j++)  // finding bomb which will be detonated 
            {
                if(i==j) 
                continue;
                int [] next = bombs[j];

                long diff_x = (long) curr[0]-next[0];
                long diff_y = (long) curr[1]-next[1];
                long rad = (long) curr[2];
                if(diff_x * diff_x + diff_y * diff_y <= rad* rad)   // condition for detonation 
                {
                    adjList.get(i).add(j);
                }
            }
        }
        
        int max_detonated=0;
    
        for(int i=0; i<n; i++)
        {
           boolean visi[]= new boolean[n];  // reset visitation array  
           int count= dfs(i, visi, adjList);
            max_detonated= Math.max(max_detonated, count);
        }
        return max_detonated;
    
    }
}