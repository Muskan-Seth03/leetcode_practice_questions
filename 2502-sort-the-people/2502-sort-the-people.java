class Solution {   //  TC: O(n^2)  SC:O(n)
    public String[] sortPeople(String[] names, int[] heights) {
       int n= names.length;

       for(int i=0; i< n; i++)
       {
            for(int j=i+1; j<n ; j++)
            {
                if(heights[j]> heights[i])
                {
                    // swap them
                    int tempH= heights[j];
                    heights[j]= heights[i];
                    heights[i]= tempH;


                    // swap names
                    String tempN= names[j];
                    names[j]= names[i];
                    names[i]= tempN;
                }
            }
           
        }
         return names;
    }
}