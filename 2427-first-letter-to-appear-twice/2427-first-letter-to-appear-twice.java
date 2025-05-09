class Solution {     //  TC:O(n)   SC:O(1)
    public char repeatedCharacter(String s) {
        //   use set data structure
        HashSet<Character>seen= new HashSet<>();

        for(char c: s.toCharArray())
        {
            if(seen.contains(c))
            {
                return c;
            }
            seen.add(c);
        }

        return '\0';  // wont reach this line becoz there must a char appearing TWICE
       
    }
}
    