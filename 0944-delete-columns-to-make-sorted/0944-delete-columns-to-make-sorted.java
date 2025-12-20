// TC: O(m * n)  SC: O(1)
class Solution {
    public int minDeletionSize(String[] strs) {
        // find how many strings are not lexicographically sorted
        int count=0;
        for(int j=0; j< strs[0].length(); j++){
            for(int i=0; i< strs.length - 1; i++){
        if(strs[i].charAt(j) > strs[i+1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}