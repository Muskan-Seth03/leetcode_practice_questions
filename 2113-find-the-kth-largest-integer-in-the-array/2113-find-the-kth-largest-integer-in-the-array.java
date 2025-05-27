class Solution {  // brute force approach (Sorting)  TC:O(n log n)  SC:O(1)
    public String kthLargestNumber(String[] nums, int k) {
        int n= nums.length;
        //sort in descending order
        Arrays.sort(nums, (a,b)->
            {
                if(a.length() != b.length())   // check length
                return b.length() - a.length();
                else                           // equal length, compare lexicographically
                return b.compareTo(a);
            }
        );
        return nums[k-1];
    }
}