class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;

        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;

        // Find the min and max bloom days
        for (int day : bloomDay) {
            l = Math.min(day, l);
            r = Math.max(day, r);
        }

        // Binary search on days
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // Check if we can make m bouquets by 'mid' day
    static boolean isValid(int[] bloomDay, int m, int k, int mid) {
        int bouquets = 0, flowers = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }
}