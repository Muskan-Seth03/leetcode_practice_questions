//Approach-3 Without DSU
//T.C : O(n + q)
//S.C : O(n)
class Solution {
    int[] component;

    public void dfs(int u, boolean[] visi, List<List<Integer>> adjList, int comp)
    {
        visi[u] = true;
        component[u] = comp;

        for(int adjNode : adjList.get(u))
        {
            if(visi[adjNode] == false)
            {
                dfs(adjNode, visi, adjList, comp);
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i+1<n; i++)
        {
            if(Math.abs(nums[i] - nums[i+1]) <= maxDiff)
            {
                adjList.get(i).add(i+1);
                adjList.get(i+1).add(i);
            }
        }

        boolean[] res = new boolean[queries.length];

        component = new int[n];
        Arrays.fill(component, -1);

        int comp = 0;

        boolean[] visi = new boolean[n];
         
        for(int i=0; i<n; i++)
        {
            if(!visi[i])
            {
                dfs(i, visi, adjList, comp);
            }
            comp++;
        }
        
        int k = 0;

        for(int[] query : queries)
        {   
            int u = query[0];
            int v = query[1];

            if(component[u] == component[v])
            {
                res[k++] = true;
            }
            else
            {
                res[k++] = false;
            }
        }   
        return res;
    }   
}