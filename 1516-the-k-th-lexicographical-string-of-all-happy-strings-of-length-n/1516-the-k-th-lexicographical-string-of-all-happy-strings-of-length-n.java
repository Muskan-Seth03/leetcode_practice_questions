class Solution { // backtracking approach  TC: O(2^n * n)  SC: O(2^n * n)
    public static void f(int n, StringBuilder sb, List<String> res)
    {
        //edge case
        if(sb.length()== n)
        {
            res.add(sb.toString());
            return;
        }
        for(char ch= 'a'; ch<='c'; ch++)
        {
            // ensure that no 2 same char are placed together  
            if(!sb.isEmpty() && ch == sb.charAt(sb.length()-1))
            {
                continue;
            }
            sb.append(ch);
            f(n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        // return res;
    } 
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(n, sb, res);

        if(res.size() < k)
        return "";
        else
        return res.get(k-1);

    }
}