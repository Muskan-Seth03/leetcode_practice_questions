class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int prev = 0;
        System.out.println(prev);
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == '1')
            {
                if(prev + 1 != i)
                {
                    return false;
                } 
                prev = i;
            }
        }
        return true;
    }
}