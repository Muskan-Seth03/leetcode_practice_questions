// TC: O(mlogm+n)
// SC: O(1)
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int m= capacity.length;
        Arrays.sort(capacity);

        // reverse the array
        for (int i = 0; i < m / 2; i++) 
        {
            int temp = capacity[i];
            capacity[i] = capacity[m - 1 - i];
            capacity[m - 1 - i] = temp;
        }
        int totalApple=0;
        for(int a: apple){
            totalApple += a;
        }
        int count=0;
        int k=0;
        while(totalApple > 0 && k < m)
        {
            totalApple = totalApple - capacity[k];
            count++;
            k++;
        }
        return count;
    }
}