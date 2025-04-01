class Solution {   // using dfs TC: O(V+E)   SC: O(V)+O(V)+O(V) => O(3V)
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visi, int[] pathVisi, int []check)
    {
        check[node]=0;
        visi[node]=1;
        pathVisi[node]=1;
        for(int it: adj.get(node))
        {
            if(visi[it]==0)
            {
                if(dfs(it, adj, visi, pathVisi, check)==true)
                return true;
            }
            else if(visi[it]==1 && pathVisi[it]==1)
            {
                return true;  /// cycle exists
            }
            
        }
        
        pathVisi[node]=0;
        check[node]=1;  // safe node found
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) { 
    int V= graph.length;
    int visi[]= new int[V];
    int pathVisi[]= new int [V];
    int check[]= new int[V];
    
    Arrays.fill(visi, 0);
    Arrays.fill(pathVisi, 0);
    
    ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
    for(int i=0; i<V;i++)
    {
        adj.add(new ArrayList<>());
    }
    for(int i=0; i<V; i++)
    {
        for(int j: graph[i])
        {
            adj.get(i).add(j);
        }
    }

    for(int i=0; i<V; i++)
    {
        if(visi[i]==0)
        {
            dfs(i, adj, visi, pathVisi, check);
        }
    }
    
     List<Integer> safeNodes= new ArrayList<>();
     for(int i=0; i<V; i++)
     {
         if(check[i]==1)
         safeNodes.add(i);
     }
     return safeNodes;
    }
}
