// TC: O(V + E)  SC: O(V + E)  
class Solution {
    private long dfs(int node, List<List<Integer>> adjList, int[]visi, long size)
    {
        visi[node]= 1;
        size=1;

        for( int adjNode : adjList.get(node))
        {
            if(visi[adjNode] == 0)
            {
                size += dfs(adjNode, adjList, visi, size);
            }
        }
        return size;

    }
    public long countPairs(int n, int[][] edges) {
        
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] visi= new int[n];
        long res=0;
        long leftNode = n;
        
        for(int i=0; i<n; i++)
        {
           
            if(visi[i] == 0)
            {
                long size=0;
                size= dfs(i, adjList, visi, size);

                res += size * (leftNode - size);

                leftNode -= size;
            }
        }
        return res;

                
    }
}