// slow ad fast pointer approach 
// traversing through indices 
// TC: O(n)  SC: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n= nums.length;
        int slow = nums[0];
        int fast= nums[nums[0]];

        while(slow != fast)
        {
            slow = nums[slow];
            fast= nums[nums[fast]];
        }

        slow= 0;
        while(slow != fast)
        {
            slow= nums[slow];
            fast= nums[fast];
        }
        return slow;
    }
}