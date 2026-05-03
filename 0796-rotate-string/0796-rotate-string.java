class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!= goal.length())
        return false;

        for(int i=0; i<s.length(); i++)
        {
            String s1= s.substring(0, i+1);
            String s2= s.substring(i+1);
            if(goal.contains(s1))
            {
                if(goal.contains(s2))
                return true;
            }
           
        }
        return false;
    }
}