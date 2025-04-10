class Solution {    // approach-1  TC:O(m*m)  SC:O(m)
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char ch[] = s.toCharArray();
        int  m = ch.length;
        int res[]= new int [m];

        for(int i=0; i<m; i++)
        {
            int counter=0;
            int row= startPos[0];     // reset counter and start coordinate when the whole string is processed or whenever we break out of loop in case of invalid string    
            int col= startPos[1];
           
            for(int j=i; j<m ; j++)
            {
                int dir_r=0; int dir_c=0;
                if(ch[j] == 'U')
                {
                    dir_r = -1; 
                    dir_c = 0;
                }
                else if(ch[j] =='D')
                {
                    dir_r = 1;
                    dir_c = 0;
                }
                else if(ch[j] == 'L')
                {
                    dir_r = 0;
                    dir_c = -1;
                }
                else 
                {
                    dir_r = 0;
                    dir_c = 1;
                }
                
                if(row + dir_r >=0 &&  row + dir_r < n && col + dir_c >= 0 &&  col + dir_c < n)
                {
                    counter++;
                    row= row + dir_r ;
                    col= col + dir_c ;
                }
                else
                {
                    break;   
                }
            }

            res[i]= counter;
        }

        return res;
    }
}