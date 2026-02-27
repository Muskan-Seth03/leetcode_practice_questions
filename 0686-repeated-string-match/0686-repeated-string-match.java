class Solution {
    public int repeatedStringMatch(String a, String b) {
        // length of string b should be multiple of string a length
        int m= a.length();
        int n= b.length();

        if(a.contains(b))
        return 1;

        // Might need to repeat string a a few more times than 
        // b.len / a.len for b.len > a.len
        int repeat = n/m;
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<repeat; i++)
        {
            sb.append(a);
        }
        if(sb.toString().contains(b))
        return repeat;

        sb.append(a);
        
        if(sb.toString().contains(b))
        return repeat + 1; 

        sb.append(a);
        
        if (sb.toString().contains(b))
        return repeat + 2;

        else
        return -1;
    }
}