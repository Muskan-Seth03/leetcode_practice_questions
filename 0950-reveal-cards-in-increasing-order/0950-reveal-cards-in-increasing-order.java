// approach-1 (sorting + skip flag) 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int i = 0;
        int j = 0;

        boolean skip = false;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        res[j] = deck[i++];
        skip = true;
        j = (j+1) % n;

        while(i < n)
        {
            if(res[j] == 0 && skip == false)
            {
                res[j] = deck[i];
                skip = true;
                j = (j+1) % n;
                i++;
            }                
            else if(res[j] == 0 && skip == true)
            {
                j = (j+1) % n;
                skip = false;
            }
            else
            {
                // res[j] != 0
                j = (j+1) % n;
            }
        }
        return res;        
    }
}