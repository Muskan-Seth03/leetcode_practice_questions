class Solution {

    final int MOD = 1_000_000_007;

    public long factorial(int n){
        long res = 1;
        for(int i = 2; i <= n; i++)
            res = (res * i) % MOD;
        return res;
    }

    public long modPow(long base, long exp){
        long result = 1;
        base %= MOD;

        while(exp > 0){
            if((exp & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public long modInverse(long x){
        return modPow(x, MOD - 2);
    }

    public int countAnagrams(String s){

        String[] arr = s.split(" ");
        long ans = 1;

        for(String word : arr){

            int[] freq = new int[26];

            for(char c : word.toCharArray())
                freq[c - 'a']++;

            int n = word.length();

            long prev = factorial(n);

            for(int f : freq){
                if(f > 1)
                    prev = (prev * modInverse(factorial(f))) % MOD;
            }

            ans = (ans * prev) % MOD;
        }

        return (int) ans;
    }
}