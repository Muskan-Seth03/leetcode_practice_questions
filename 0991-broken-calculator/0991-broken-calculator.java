// TC: O(log target)  SC: O(log target)
class Solution {
    public int brokenCalc(int startValue, int target) {
        // base case
        if(startValue >= target)
        return startValue - target;
        if(target % 2 ==0)
        {
            return 1+ brokenCalc(startValue, target / 2);
        }
        return 1+ brokenCalc(startValue, target+1); 
    }
}