// 2 pass solution
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i=0;
        int j= n-1;
        int maxDis = 0;
        while(i < j)
        {
            if(colors[i] != colors[j])
            {
                maxDis = Math.max(maxDis, j);
            }
            else
            {
                j--;
            }
        }
        j = n-1;
        while(i < j)
        {
            if(colors[i] != colors[j])
            {
                maxDis = Math.max(maxDis, Math.abs(i - j));
            }
            else
            {
                i++;
            }
        }
        return maxDis;
    }
}