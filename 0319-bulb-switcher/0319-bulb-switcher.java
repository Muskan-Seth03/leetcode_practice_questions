// find the number of perfect squares of a n ==> (take floor value)
// TC: O(1)  SC: O(1)
class Solution {
    public int bulbSwitch(int n) {
        int perfectSquare = (int) Math.floor(Math.sqrt(n));
        return perfectSquare;
    }
}