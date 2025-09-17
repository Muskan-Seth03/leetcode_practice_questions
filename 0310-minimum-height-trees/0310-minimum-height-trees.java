//TC: O(n) ===> O(n) for adjList formation + queue form + each node processed once 
//SC: O(n) ===> O(n) for queue in worst case + adjList + degree array 
import java.util.*;

class Solution {
    private List<List<Integer>> adj;
    private int degree[];
  
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        
        adj = new ArrayList<>();
        degree= new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // create adjacency list 
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(degree[i] == 1)
            q.offer(i);
        }
        List<Integer> res= new ArrayList<>();
        while(!q.isEmpty())
        {
            res= new ArrayList<>();
            int size= q.size();
            for(int i=0; i<size; i++)
            {
                int node= q.poll();
                res.add(node); // re stores the n th layer nodes...then n-1 th layer node and so on.
                for(int adjNode: adj.get(node))
                {
                    degree[adjNode]--;

                    if(degree[adjNode]== 1)
                    q.offer(adjNode);
                }
            }            
        }
        return res;      
    }
}