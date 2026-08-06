// BFS using indegree concept
// TC: O(V+E)   SC: O(V+E)
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] invocation : invocations)
        {
            int u = invocation[0];
            int v = invocation[1];

            adjList.get(u).add(v);
            indegree[v]++;
        }

        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer> result = new ArrayList<>();

        suspicious[k] = true;
        q.offer(k);

        while(!q.isEmpty())
        {
            int u = q.poll();

            for(int adjNode : adjList.get(u))
            {
                indegree[adjNode]--;
                if(!suspicious[adjNode])
                {
                    suspicious[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }

        boolean cannotRemove = false; 
        for(int i=0; i<n; i++)
        {
            if(suspicious[i] && indegree[i] > 0)
            {
                cannotRemove = true;
                break;
            }

            if(!suspicious[i])
            {
                result.add(i);
            }
        }

        List<Integer> arr = new ArrayList<>();
        if(cannotRemove)
        {
            for(int i=0; i<n; i++)
            {
                arr.add(i);
            }
            return arr;
        }
        return result;
    }
}