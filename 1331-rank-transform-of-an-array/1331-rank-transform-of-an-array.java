// TC: O(n)  SC: O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n= arr.length;
        int[] result = new int[n];

        int rank = 1;

        Map<Integer, Integer> rankMap = new HashMap<>();

        int[] temp = arr.clone();
        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if(i > 0 && temp[i] > temp[i-1])
            {
                rank++;
            }
            rankMap.put(temp[i], rank);
        }
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}