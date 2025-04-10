class Solution {   // brute force approach  TC:O(n)  SC:O(n)
    public boolean judgeCircle(String moves) {
        char[] ch= moves.toCharArray();
        int n= ch.length;
        int row=0;
        int col=0;
        int dir_r=0;
        int dir_c=0;
        for(int i=0; i<n; i++)
        {
            if(ch[i]=='U')
            {
                dir_r=-1;
                dir_c= 0;
            }
            else if(ch[i] == 'D')
            {
                dir_r= 1;
                dir_c= 0;
            }
            else if(ch[i] == 'L')
            {
                dir_r= 0;
                dir_c= -1;
            }
            else
            {
                dir_r= 0;
                dir_c= 1;
            }
            row= row + dir_r;
            col= col + dir_c;

        }

        if(row == 0 && col==0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}