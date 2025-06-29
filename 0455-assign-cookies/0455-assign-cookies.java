class Solution {    // greedy approach  TC:O(n log n)+ O(m log m) +O(m+n)   SC:O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while(i< s.length && j< g.length)
        {
            if(s[i]>= g[j])
            {
                i++;
                j++;
            }
            else
            i++;
        }
        return j;
    }
}