class Solution {   // TC: O(n)   SC:O(n)
    public int[] resultArray(int[] nums) {
        int n= nums.length;
        List<Integer> arr1= new ArrayList<>();
        List<Integer> arr2= new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        int j=2;
        while(j<n)
        {
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1))
            {
                arr1.add(nums[j]);
                j++;
            }
            else
            {
                arr2.add(nums[j]);
                j++;
            }
        }

        for(int i=0; i < arr2.size(); i++)
        {
            arr1.add(arr2.get(i));
        }

        int[] result = new int[arr1.size()];
        for (int i = 0; i < arr1.size(); i++) 
        {
            result[i] = arr1.get(i);  // auto-unboxing Integer -> int
        }
        return result;
       
    }
}