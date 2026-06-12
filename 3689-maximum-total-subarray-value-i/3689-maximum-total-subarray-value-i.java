class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Arrays.stream(nums).max().getAsInt();
        long min = Arrays.stream(nums).min().getAsInt();

        if(nums.length == 1)
        return 0;

        return (long) (max - min) * k;
    }
}