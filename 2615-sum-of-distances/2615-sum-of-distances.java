// TC: O(n)
// SC: O(n)
// prefix sum approach
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        Map<Integer, Long> indexCount = new HashMap<>();
        Map<Integer, Long> indexSum = new HashMap<>();

        // Left to Right
        for (int i = 0; i < n; i++) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += (freq * i) - sum;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        Map<Integer, Long> indexCount1 = new HashMap<>();
        Map<Integer, Long> indexSum1 = new HashMap<>();

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {
            long freq = indexCount1.getOrDefault(nums[i], 0L);
            long sum = indexSum1.getOrDefault(nums[i], 0L);

            arr[i] += sum - (freq * i);

            indexCount1.put(nums[i], freq + 1);
            indexSum1.put(nums[i], sum + i);
        }

        return arr;
    }
}