// TC: O(k * k)   SC: O(1)
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;

        for(int col = y; col < y+k ; col++)
        {
            int start = x;
            int end= x+k-1;
            while(start <= end)
            {
                //swap start and end
                int temp = grid[start][col];
                grid[start][col] = grid[end][col];
                grid[end][col] = temp;


                start++;
                end--;
            }
        }
        return grid;
    }
}