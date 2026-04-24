class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, right = 0, up = 0, down = 0;
        for(char move : moves.toCharArray())
        {
            if(move == 'L')
            {
                left++;
            }
            else if(move == 'R')
            {
                right++;
            }
            else if(move == 'U')
            {
                up++;
            }
            else
            {
                down++;
            }
        }
        if(Math.abs(left - right) == 0 && Math.abs(up - down) == 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}