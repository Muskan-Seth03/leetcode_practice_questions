// TC: O(n)  SC: O(n)
class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int[] arr = new int[n];
        int k = 0;

        // store seat indices
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                arr[k++] = i;
            }
        }

        // if seats are zero or odd, no valid ways
        if (k == 0 || k % 2 != 0) {
            return 0;
        }

        final int MOD = 1_000_000_007;

        long result = 1;
        int prevEnd = arr[1];   

        // process next seat pairs
        for (int i = 2; i < k; i += 2) {
            int currStart = arr[i];
            result = (result * (currStart - prevEnd)) % MOD;
            prevEnd = arr[i + 1]; // update end of the next pair
        }

        return (int) result;
    }
}
