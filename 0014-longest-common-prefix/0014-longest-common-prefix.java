class Solution {  // TC:O(n log n  + m)   SC:O(m) for the storing the longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) 
        return "";
        
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String start= strs[0]; 
        String end= strs[strs.length-1];

        for(int i=0; i< Math.min(start.length(), end.length()); i++)
        {
            if(start.charAt(i)!= end.charAt(i)) 
            // if character of start and end word desnt match , then return the already formed common prefix stored in ans 
            {
                return ans.toString();  //return whatever stored in ans
            }
            //char match
            ans.append(start.charAt(i));
        }

        return ans.toString();
    }
}