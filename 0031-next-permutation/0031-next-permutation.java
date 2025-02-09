import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        // Step 1: Find the break point from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i; // Found the dip
                break;
            }
        }
        //if no dip
        // If no next permutation is possible, sort the array (smallest permutation)
        if (ind == -1) {
            Arrays.sort(nums);
            return; 
        }

        // Step 2: Find the next greater element to swap
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind); 
                break;
            }
        }

        // Step 3: Reverse the remaining el
        int left = ind + 1, right = n - 1;
        while (left < right) { 
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
