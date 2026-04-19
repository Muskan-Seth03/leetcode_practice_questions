class Solution {
    public int reverse(int n)
    {
        int num = n;
        int rev = 0;
        while(num != 0)
        {
            int d = num % 10;
            rev = rev * 10 + d;
            num = num/10;
        } 
        return rev;
    }
    public int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n - rev);
    }
}