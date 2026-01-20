// Approach (Brute Force All Possible Answers)
// T.C : O(n * m), m = maximum number in nums
// S.C : O(1)
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            boolean found = false;

            for (int x = 0; x < num; x++) {
                if ( (x | (x + 1)) == num ) {
                    result[i] = x;
                    found = true;
                    break;
                }
            }

            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }
}