class Solution { // optimal approach TC:O(2*M*N) SC: O(1)

    public void setZeroes(int[][] matrix) {
        int col0 = 1;

        // set 0 in the 1 st row and 1 st cols if its corresponding cell contains 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // mark the i th row
                    matrix[i][0] = 0;

                    // mark the j th col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else col0 = 0;
                }
            }
        }

        //convert number to 0 if either 1 st row or 1 st cols is marked as zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        // finally mark the 1st col and then 1 st row  to get the correct answer
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // mark the 1 st row
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
