// approach-2 (using queue)  TC: O(n log n)  SC: O(n) 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;

        int[] res = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for(int k=0; k<n; k++)
        {
            q.offer(k);
        }

        int i = 0;
        while(!q.isEmpty())
        {
            int ind = q.poll();
            res[ind] = deck[i++];
            
            if (!q.isEmpty()) 
            {
                q.offer(q.poll());
            }
        }
        return res;        
    }
}