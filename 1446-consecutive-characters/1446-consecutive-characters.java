class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int count = 1;
        int maxCount = 0;
        for(int i=1; i<n; i++)
        {
            if(s.charAt(i) == s.charAt(i-1))
            {
                count++;
            }
            else
            {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}