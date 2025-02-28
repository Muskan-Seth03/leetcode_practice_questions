class Solution { //recursion TC: O(2^n) SC:O(n)
    public int fib(int n) {
        if(n<=1)
        return n;
        else
        return fib(n-1) + fib(n-2);
        
    }
}