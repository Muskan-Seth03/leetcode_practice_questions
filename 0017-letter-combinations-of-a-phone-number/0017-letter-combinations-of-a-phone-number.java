class Pair {
    int key;
    String value;
    Pair(int key, String value){
        this.key= key;
        this.value= value;
    }
}
class Solution {
    public static void f(int i, char digitArray[], List<Pair>pairs, StringBuilder sb,List<String> ans)
    {
        // base case
        if(i==digitArray.length)
        {
            ans.add(sb.toString());
            return;
        }

        int digit = digitArray[i] - '0';
        String str = "";
        for(Pair p : pairs)
        {
            if(p.key==digit)
            {
                str= p.value;
                break;
            }
        }
        for(int j=0; j<str.length(); j++)
        {
            sb.append(str.charAt(j));
            f(i+1, digitArray, pairs, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
    public List<String> letterCombinations(String digits) {
        int n= digits.length();
        List<String> ans= new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(2, "abc"));
        pairs.add(new Pair(3, "def"));
        pairs.add(new Pair(4, "ghi"));
        pairs.add(new Pair(5, "jkl"));
        pairs.add(new Pair(6, "mno"));
        pairs.add(new Pair(7, "pqrs"));
        pairs.add(new Pair(8, "tuv"));
        pairs.add(new Pair(9, "wxyz"));

        char digitArray[] = digits.toCharArray();
        StringBuilder sb= new StringBuilder();
    
        f(0, digitArray, pairs, sb, ans);
        
        return ans;       
    }
}