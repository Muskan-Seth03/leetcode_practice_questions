class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        st.push(-1);

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(i);
            }
            else if(s.charAt(i) == ')')
            {
                if(!st.isEmpty() && st.peek() != -1 && s.charAt(st.peek()) == '(')
                {
                    st.pop();
                }
                else
                {
                    st.push(i);
                }
            }
        }
        st.push(s.length());

        int[] arr = new int[st.size()];
        int i=0;

        while(!st.isEmpty())
        {
            arr[i++] = st.peek();
            st.pop();
        }

        int maxLen = 0;
        for(int j =0; j+1 < arr.length; j++)
        {
            int currLen = arr[j] - arr[j+1] - 1;

            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}