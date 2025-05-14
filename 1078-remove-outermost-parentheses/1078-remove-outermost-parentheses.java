class Solution {   // using stack   TC:O(n)  SC:O(n)
    public String removeOuterParentheses(String s) {
        Stack<Character> stack= new Stack<>();
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')
            {
                if(stack.size()> 0)
                {
                    sb.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }
            else
            {
                stack.pop();
                if(stack.size() > 0) 
                {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
        
    }
}