// TC: O(m log m)   SC: O(m)
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Maps: x → all y's; y → all x's
        Map<Integer, TreeSet<Integer>> mpX = new HashMap<>();
        Map<Integer, TreeSet<Integer>> mpY = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            mpX.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            mpY.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            TreeSet<Integer> setX = mpX.get(x);
            TreeSet<Integer> setY = mpY.get(y);

            // Check if this (x,y) is minimum or maximum in its row/column
            if (setX.first() == y || setY.first() == x) {
                continue;
            }

            if (setX.last() == y || setY.last() == x) {
                continue;
            }

            count++;
        }

        return count;
    }
}
