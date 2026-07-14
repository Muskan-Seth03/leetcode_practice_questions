// bfs approach 
// TC: O(V + E)    SC: O(V + E)
class Solution {
    public void bfs(int start, List<List<Integer>> adjList, boolean[] visi, int[] count) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visi[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            count[0]++;                       // vertices
            count[1] += adjList.get(node).size(); // degree sum

            for (int neighbour : adjList.get(node)) {

                if (!visi[neighbour]) {
                    visi[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visi = new boolean[n];

        int res = 0;

        for (int i = 0; i < n; i++) {

            if (!visi[i]) {

                int[] count = new int[2];

                bfs(i, adjList, visi, count);

                int vertices = count[0];
                int degreeSum = count[1];

                if (degreeSum == vertices * (vertices - 1))
                    res++;
            }
        }

        return res;
    }
}