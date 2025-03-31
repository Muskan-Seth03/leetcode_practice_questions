class Solution {   // using bfs (Kahn's algorithm --> indegree+ queue) TC: O(V*logV)+ O(V+E)
    public List<Integer> eventualSafeNodes(int[][] graph) {       // SC:O(V)+O(V)+O(V) => O(3V)
        int V= graph.length;
        List<List<Integer>> reverseList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseList.add(new ArrayList<>());
        }
        
        int [] indegree= new int[V];
        int visi[]= new int[V];
        for(int i=0; i<V; i++)
        {
            for(int j: graph[i])
            {
                reverseList.get(j).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        ArrayList<Integer> safeNodes= new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int node= q.poll();
            safeNodes.add(node);    
            for(int it: reverseList.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
            
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}