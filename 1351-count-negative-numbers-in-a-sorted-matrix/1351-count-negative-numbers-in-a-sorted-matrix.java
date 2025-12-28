// binary search TC:O(m log n)  SC:O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int count= 0;
        
        for(int i=0; i<m; i++)
        {
            int low= 0;
            int high= n-1;
            while(low<= high)
            {
                int mid= (low + high)/2;
                if(grid[i][mid] < 0)
                {
                    count+= (high - mid + 1);
                    high = mid - 1;
                }
                else
                {
                    low= mid + 1;
                }
            }
        }
        return count;
    }
}