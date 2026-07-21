// iterate L -> R  eliminate extra close bracket
// iterate R -> L eliminate extra open bracket

// TC: O(n)    SC: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        String res = "";

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                open++;
                res += s.charAt(i);
            }          
            else if(s.charAt(i) == ')')
            {
                if(open > 0)
                {
                    open--;
                    res += s.charAt(i);
                }
            }
            else
            {
                res += s.charAt(i);
            } 
        }

        int close = 0;
        String result = "";
        for(int i = res.length()-1; i >= 0; i--)
        {
            if(res.charAt(i) == ')')
            {
                close++;
                result += res.charAt(i);
            }
            else if(res.charAt(i) == '(')
            {
                if(close > 0)
                {
                    close--;
                    result += res.charAt(i);
                }
            }
            else
            {
                result += res.charAt(i);
            }
        }
        return new StringBuilder(result).reverse().toString();
    }
}