// optimal approach -- iterate from bottom left corner
// TC:O(m + n)  SC:O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int count= 0;
        int j=0;
        int i= m-1;
        while(i >= 0 && j < n)
        {   
            if(grid[i][j] < 0)
            {
                count += (n - j);  
                i--; 
            }
            else
            {
               j++;
            }
        }
        return count;
    }
}