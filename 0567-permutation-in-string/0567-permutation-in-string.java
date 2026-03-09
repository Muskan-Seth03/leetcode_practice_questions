// sorting approach
// TC: O((n log n) * (n - m))   SC: O(m)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m= s1.length();
        int n= s2.length();

        if(m > n)
        {
            return false;
        }
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);

        String sorted = new String(arr);

        for(int i=0; i <= n - m; i++)
        {
            String substring = s2.substring(i, i + m);

            char[] arr1 = substring.toCharArray();
            Arrays.sort(arr1);

            String sortedSubstring = new String(arr1);


            if(sortedSubstring.equals(s1))
            {
                return true;
            }
        }
        return false;
    }
}