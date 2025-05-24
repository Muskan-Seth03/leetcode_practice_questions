import java.util.*;     // using 3 variables  TC:O(n)  SC:O(1)
class Solution {
    public int thirdMax(int[] nums) {
       int n= nums.length;
       Integer first= null, second= null, third= null;

       for(int i=0; i< n; i++)
       {
            if( first != null && nums[i] == first ||
                second != null &&  nums[i] == second ||
                third != null && nums[i] == third)
                continue;

            if(first== null || nums[i]> first)
            {
                third= second;
                second= first;
                first= nums[i];
            }
            else if(second== null || nums[i] > second)
            {
                third= second;
                second= nums[i];
            }
            else if(third == null || nums[i] > third)
            {
                third= nums[i];
            }
        }

        return third== null ? first: third ;
    }
}