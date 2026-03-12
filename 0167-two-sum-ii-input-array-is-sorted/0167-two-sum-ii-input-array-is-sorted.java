class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            int rem = target - numbers[i];
            if(map.containsKey(rem))
            {
                return new int[] {map.get(rem) + 1, i+1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}