// TC: O(n)    SC: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(i);
            }
            else if(ch == ')')
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
                else 
                {
                    set.add(i);
                }
            }
        }
        // only opening bracket present then, add them to set
        while(!st.isEmpty())
        {
            set.add(st.peek());
            st.pop();
        }

        // skip them in orig string

        String res = "";
        for(int i=0; i<s.length(); i++)
        {
            if(!set.contains(i))
            {
                res += s.charAt(i);
            }
        }
        return res;
    }
}