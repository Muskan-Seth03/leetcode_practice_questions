// TC: O(n)  SC:O(n)
import java.util.*;
class Solution {
    public String reverseWords(String s) {
        String[] sArray= s.trim().split("\\s+");
        List<String> sList= Arrays.asList(sArray);
        Collections.reverse(sList);
        
        return String.join(" ", sList);
    }
}