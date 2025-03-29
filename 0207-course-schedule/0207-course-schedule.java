class Solution {      // Kahn's algorithm to detect cycle in Directed graph using BFS (Queue)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N= numCourses;
        int P= prerequisites.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<P; i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // indegree array
        int indegree[]= new int [N];
        for(int i=0; i<N; i++)
        {
            for(int it: adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0; i<N; i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        
        int i=0;
        while(!q.isEmpty())
        {
            int node= q.remove();
            i++;
            
            for(int it: adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                q.offer(it);
            }
        }
        
        if(i==N)
        return true;
        
        else
        return false;
        
    }
}