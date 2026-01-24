// TC: O(n log n)  SC: O(1)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n= people.length;
        int i=0;
        int j= n-1;
        int boatCount= 0;
        Arrays.sort(people);
        while(i <= j)
        {
            if(people[i] + people[j] <= limit)
            {
                i++;
                j--;
            }
            else
            {
                j--;
            }
            boatCount++;
        }
        return boatCount;
    }
}