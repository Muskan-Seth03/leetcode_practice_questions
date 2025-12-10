// Element at index 0 has the unique minimum complexity (no other element can match its value.
// TC: O(n)  SC: O(n)
class Solution {
    public int countPermutations(int[] complexity) {
        int n= complexity.length;
        Map<Integer, Integer> map= new HashMap<>();
        for(int num: complexity){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int flag= 0;
        // num must be unique ==> freq(num) == 1
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() == complexity[0]){
                if(entry.getValue() == 1){
                    flag= 1;
                }
            } 
        }
        // num must be minimum
        int min= Integer.MAX_VALUE;

        for(int num: complexity){
            min = Math.min(num, min);
        }

        final int MOD= 1_000_000_007;
        if(flag == 1 && min == complexity[0]){
            // find permutation
            long fact = 1;
            for (int i = 1; i <= n - 1; i++) {
                fact = (fact * i) % MOD;
            }
            return (int) fact;
        }
        return 0;
    }
}