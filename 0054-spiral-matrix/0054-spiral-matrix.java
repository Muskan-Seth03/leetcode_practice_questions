class Solution {   //TC:O(n*m) SC:O(n*m)
    public List<Integer> spiralOrder(int[][] matrix) {
        int n= matrix.length;  // for rows
        int m= matrix[0].length;  // for cols
        int left =0, top=0;
        int bottom = n-1, right= m-1;

        ArrayList<Integer> list= new ArrayList<>();
        while(left <=right && top<=bottom)
        {   // first outer circle traversed
            // from left to right
            for(int i=left; i<=right; i++)
            {
                list.add(matrix[top][i]);
            }
            top++;

            // from right to bottom 
            for(int j=top; j<=bottom; j++)
            {
                list.add(matrix[j][right]);
            }
            right--;

            // from bottom to left
            if(top<=bottom)
            {
                for(int i=right; i>=left; i--)
                {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right)
            {
                // from left to top
                for(int i=bottom; i>=top; i--)
                {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
        
    }
}