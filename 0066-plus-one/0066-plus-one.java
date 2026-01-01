class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from last digit
        for (int i = n - 1; i >= 0; i--) {

            // If digit is less than 9, just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // digit == 9 → becomes 0, carry continues
            digits[i] = 0;
        }

        // If all digits were 9
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
