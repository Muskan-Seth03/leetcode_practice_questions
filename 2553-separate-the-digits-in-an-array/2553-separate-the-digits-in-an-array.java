// TC: O(d)  SC: O(d)
class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int num : nums)
        {
            List<Integer> list = new ArrayList<>();
            while(num > 0)
            {
                int d = num % 10;
                list.add(d);  
                num = num / 10;                              
            }
            Collections.reverse(list);
            ans.addAll(list);
        }
        
        int[] arr = ans.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        return arr;
    }
}