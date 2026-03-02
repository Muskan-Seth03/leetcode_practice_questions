// TC: O(n^2)  SC: O(n)
class Solution {
    public void swap(int[] endZeroes, int i, int j)
    {
        int temp = endZeroes[i];
        endZeroes[i] = endZeroes[j];
        endZeroes[j] = temp;
    }
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] endZeroes =  new int[n];

        for(int i=0; i<n; i++)
        {
            int j = n-1;
            int count=0;

            while(j >= 0 && grid[i][j] == 0) 
            {  
                count++;
                j--;
            }
            endZeroes[i] =  count;
        }

        int swaps = 0;
        for(int i = 0; i < n; i++)
        {
            int need = n - i - 1;
            int j = i;         // check whether curr o in row is sufficient 
            while(j < n && endZeroes[j] < need)
            {
                j++;
            }
            if(j == n)
            return -1;

            swaps += (j-i);
            // reflect swap in array
            while(i < j)
            {
                swap(endZeroes, j, j - 1);
                j--;
            }
        }
        return swaps;
    }
}