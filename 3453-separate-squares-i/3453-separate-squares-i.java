// Binary search on y coordinates
// TC: O(n)  SC: O(1)
class Solution {
    public double areaBelow(double mid, int[][] squares)
    {
        double area=0;
        for(int[] square: squares)
        {
            double y= square[1];
            double len= square[2];

            if(mid >= y+len)
            {
                // whole square area is counted
                area += len * len; 
            }
            else if((y < mid) && (mid < (y + len)))
            {
                // add the area of square below the mid line
                area += len * (mid - y);
            }
        }
        return area;
    }

    public double separateSquares(int[][] squares) {
        double y=0;
        double totalArea=0;
        double min= Double.MAX_VALUE;
        double max= Double.MIN_VALUE;

        for(int [] square: squares)
        {
            double len= square[2];
            totalArea += len * len;
            min= Math.min(min, square[1]);
            max= Math.max(max, square[1] + len); 
        }

        double target= totalArea/2;
        double low= min, high= max;

        // binary search logic
        while(low< high)
        {
            // handling infinite case
            if(high - low < Math.pow(10, -5))
            {
                break;
            }
            double mid= low + (high - low)/2;
            if(areaBelow(mid, squares) < target)
            {
                low = mid;
            }
            else
            {
                y = mid;
                high= mid;
            }
        }
        return y;   // return the min y coordinate
    }
}