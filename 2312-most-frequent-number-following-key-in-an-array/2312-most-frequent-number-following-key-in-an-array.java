class Solution {   // TC:O(n)  SC:O(n)
    public int mostFrequent(int[] nums, int key) {
        int n= nums.length;
       
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< n-1 ; i++)
        {
            if(nums[i] == key)
            {
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0) +1);    // O(1)
            }
        }  
       
        int max_freq=0;
        int target=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())    // O(n)
        {
            if( entry.getValue() > max_freq)
            {
                max_freq= entry.getValue();
                target= entry.getKey();
            }
        }
        return target;
    
    }
}