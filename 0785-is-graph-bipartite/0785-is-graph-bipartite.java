// using dfs TC: O(V+E)  SC: O(V+E)
class Solution {
    private boolean dfs(List<List<Integer>> adjList, int node, int[]color, int currColor)
    {
        color[node]= currColor;

        for(int adjNode: adjList.get(node))
        {
            if(color[adjNode]== color[node])
            {
                return false;
            }
            // if adjNode is not colored
            if(color[adjNode]== -1)
            {
                if(dfs(adjList, adjNode, color, 1- currColor)== false)
                {
                    return false;
                }
            }
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;

        int []color= new int[n];
        Arrays.fill(color, -1);

        List<List<Integer>> adjList= new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                adjList.get(i).add(neighbor);
            }
        }
            for(int i=0; i<n; i++)
        {
            if(color[i]== -1)
            {
                if(dfs(adjList, i, color, 1)== false)
                return false;
            }
        }
        return true;
    }
}