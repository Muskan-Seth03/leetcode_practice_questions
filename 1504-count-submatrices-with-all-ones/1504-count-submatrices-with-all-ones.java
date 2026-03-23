// TC: O(m * m * n)
class Solution {
    public int oneDArrayCount(int[] arr)
    {
        int subCount=0;
        int consOne =0;

        for(int a : arr)
        {
            if(a == 0)
            {
                consOne = 0;
            }
            else
            {
                consOne++;
            }
            subCount += consOne;
        }
        return subCount;
    }

    public int numSubmat(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        
        int res = 0;
        for(int startRow = 0; startRow < m; startRow++)
        {
            int[] vec = new int[n];
            Arrays.fill(vec, 1);

            for(int endRow =startRow; endRow < m; endRow++)
            {
                for(int col = 0; col < n; col++)
                {
                    vec[col] = vec[col] & mat[endRow][col];
                }
                res += oneDArrayCount(vec);
            }
        }
        return res;
    }
}