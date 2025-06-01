class Solution {   // TC:O(n log n  + m)   SC:O(m) for the storing the longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs== null || strs.length ==0)
        return "";

        Arrays.sort(strs);
        String start= strs[0];
        String end= strs[strs.length -1];
        
        StringBuilder ans= new StringBuilder();
        for(int i=0; i < Math.min(start.length(), end.length()); i++)
        {
            if(start.charAt(i)!= end.charAt(i))
            break;
            ans.append(start.charAt(i));
        }

        return ans.toString();
    }
}