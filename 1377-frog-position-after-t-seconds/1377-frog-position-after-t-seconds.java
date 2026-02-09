// dfs approach
// TC: O(n)   SC: O(n)
class Solution {
    public double dfs(int src, List<List<Integer>> adjList, int[] visi, int t, int target, double prob)
    {
        visi[src] = 1;
        // base case 1
        if(t == 0)
        {
            if(src == target)
            {
                return prob;
            }
        }
        // compute children
        int children = 0;
        for(int adjNode: adjList.get(src))
        {
            if(visi[adjNode] == 0)
            {
                children++;
            }
        }
        if(t == 0)
        return 0.0;
        
        if(children == 0 && src == target)
        {
            return prob;
        }

        for(int adjNode : adjList.get(src))
        {
            if(visi[adjNode] == 0)
            {
                double res = dfs(adjNode, adjList, visi, t-1, target, (double) prob / children);
                if(res > 0) return res;
            }
        }
        return 0.0;
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0; i<n+1; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] visi = new int[n+1];
        Arrays.fill(visi, 0);

        return dfs(1, adjList, visi, t, target, 1.0);
    }
}