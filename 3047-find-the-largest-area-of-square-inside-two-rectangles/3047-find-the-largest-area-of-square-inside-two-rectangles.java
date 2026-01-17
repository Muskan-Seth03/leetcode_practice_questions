// TC: O(n^2)  SC: O(1)
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxLen = 0;
        int len = 0;
        for(int i=0; i < bottomLeft.length; i++)
        {   
            int leftA= bottomLeft[i][0];
            int bottomA= bottomLeft[i][1];

            int rightA= topRight[i][0];
            int topA= topRight[i][1];

            for(int j=i+1; j < topRight.length; j++)
            {
                int leftB= bottomLeft[j][0];
                int bottomB= bottomLeft[j][1];

                int rightB= topRight[j][0];
                int topB= topRight[j][1];

                // find x_overlap
                int leftBoundary= Math.max(leftA, leftB);
                int rightBoundary= Math.min(rightA, rightB);
                
                int x_overlap = rightBoundary - leftBoundary > 0 ? rightBoundary - leftBoundary : 0;

                // find y_overlap
                int topBoundary= Math.min(topA, topB);
                int bottomBoundary= Math.max(bottomA, bottomB);
                
                int y_overlap= topBoundary - bottomBoundary > 0 ? topBoundary - bottomBoundary : 0;

                len= Math.min(x_overlap, y_overlap);
                maxLen= Math.max(maxLen, len);
            }
           
        }
        return 1L * maxLen * maxLen;
    }
}