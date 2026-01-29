// Floyd Warshall algorithm
//T.C : O(n)  -> Because other for loops run only for constant time 26*26*26
//S.C : O(1) -> We take distances matrix of 26*26 which is constant
class Solution {
    public void floydWarshall(int[][] adjMatrix, char[] original, char[] changed, int[] cost)
    {
        for(int i=0; i<original.length; i++)
        {
            int s= original[i] - 'a';
            int t= changed[i] - 'a';
            adjMatrix[s][t] = Math.min(adjMatrix[s][t],  cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (adjMatrix[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < 26; j++) {
                    if (adjMatrix[k][j] == Integer.MAX_VALUE) continue;

                    adjMatrix[i][j] = Math.min(
                        adjMatrix[i][j],
                        adjMatrix[i][k] + adjMatrix[k][j]
                    );
                }
            }
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // create adjMatrix of size 26*26
        int[][] adjMatrix= new int[26][26];
        for(int i = 0; i < 26; i++)
        {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }

        floydWarshall(adjMatrix, original, changed, cost);

        long ans=0;
        for(int i=0; i<source.length(); i++)
        {
            if(source.charAt(i) == target.charAt(i))
            continue;

            if(adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE)
            return -1;

            ans += adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return ans;
    }
}