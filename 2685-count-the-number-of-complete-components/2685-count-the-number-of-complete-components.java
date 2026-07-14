// DFS approach
// TC: O(V + E)  SC: O(V)
class Solution {
    public void dfs(int i, List<List<Integer>> adjList, boolean[] visi, int[] count)
    {   
        visi[i] = true;
        count[0] += 1;
        count[1] += adjList.get(i).size();

        for(int j=0; j< adjList.get(i).size(); j++)
        {
            List<Integer> neighbour = adjList.get(i);
            
            if(!visi[neighbour.get(j)])
            dfs(neighbour.get(j), adjList, visi, count);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visi = new boolean[n];
        Arrays.fill(visi, false);

        for(int i=0; i<n; i++)
        {
            if(!visi[i])
            {
                int[] count = new int[2];

                dfs(i, adjList, visi, count);

                int v = count[0];
                int e = count[1];

                if((v*(v-1)) == e)
                res++;
            }
        }
        return res;
    }
}