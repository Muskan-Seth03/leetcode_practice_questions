// TC: O(n)    SC: O(n)
class Solution {
    public int calculate(String s) {
        int number = 0;
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) 
            {
                number = number * 10 + (ch - '0');
            }
            else if(ch == '+')
            {
                result = result + sign * number;
                number = 0;
                sign = 1;
            }
            else if(ch == '-')
            {
                result = result + sign * number;
                number = 0;
                sign = -1;
            } 
            else if(ch == '(')
            {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            }
            else if(ch == ')')
            {
                result = result + sign * number;
                number = 0;
                result *= stack.pop(); // multiply sign
                result += stack.pop(); // add old result to new result
            }
        } 
        result = result + sign * number;
        return result;       
    }
}