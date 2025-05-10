class Solution {   // TC:O(n + m)   SC:O(m) 
    public int mostFrequentEven(int[] nums) {
      int [] arr = new int[100001];

      for(int i=0;i<nums.length;i++){
        if(nums[i]%2==0){
            arr[nums[i]]++;
        }
      }

        int maxi = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
                ans = i;
            } else if (arr[i] == maxi && maxi != 0) {
                ans = Math.min(ans, i);
            }
        }  
      return ans;
    }
}