class Solution {     // TC:O(n)   SC:O(n)
    public int maxDepth(String s) {
        Stack<Character> stack= new Stack<>();
        int count=0;
        int max_count= Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                    count--;
                }          
            }
            max_count= Math.max(max_count,  count);
        }        
        return max_count;
    }
}