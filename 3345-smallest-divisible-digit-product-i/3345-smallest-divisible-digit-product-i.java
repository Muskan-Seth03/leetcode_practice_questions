class Solution {
    public int productOfDigits(int num)
    {
        int prod = 1;
        while(num > 0)
        {
            int d = num % 10;
            prod *= d;
            num = num /10; 
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        for(int i = n; i <= 100; i++)
        {
            if(productOfDigits(i) % t == 0)
            {
                return i;
            }
        }
        return n;
    }
}