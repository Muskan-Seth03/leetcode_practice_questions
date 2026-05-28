class Solution {
    public int operate(int a, int b, String token)
    {
        if(token.equals("+"))
        return a + b;
        else if(token.equals("-"))
        return b - a;
        else if(token.equals("*"))
        return a * b;
        else  
        return b / a;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String token : tokens)
        {
            if(token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/"))
            {
                int val1 = s.pop();
                int val2 = s.pop();
                int res = operate(val1, val2, token);
                s.push(res);
            }
            else
            s.push(Integer.valueOf(token));
        }
        return s.peek();
    }
}