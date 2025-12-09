// Two pass solution
// TC:O(n)  SC:O(1)
class Solution {
    public int specialTriplets(int[] nums) {
        int n= nums.length;
        Map<Integer, Integer> left= new HashMap<>();

        Map<Integer, Integer> right= new HashMap<>();
        for(int num: nums){
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        long count= 0;
        final int MOD = 1_000_000_007;
        
        for(int j=0; j<n; j++){
            right.put(nums[j], right.get(nums[j])-1);

            if(right.get(nums[j]) == 0)
            {
                right.remove(nums[j]);
            }
            int x= nums[j] * 2;
            long leftCount = (left.containsKey(x) ? left.get(x) : 0);
            long rightCount = (right.containsKey(x) ? right.get(x): 0);

            count = ((count + (leftCount * rightCount) % MOD) % MOD); 
            
            left.put(nums[j], left.getOrDefault(nums[j], 0) + 1);
        }
        return (int)count;
    }
}