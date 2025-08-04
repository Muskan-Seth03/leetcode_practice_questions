//monotonic stack  TC: O(2N)  SC: O(N) + O(N)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums2.length;
        int res[]= new int[nums1.length];
        Stack<Integer>s=new Stack<>();
        Map<Integer, Integer> ngeMap= new HashMap<>();
        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty()  && s.peek() <= nums2[i])
            {
                s.pop();
            }
            ngeMap.put(nums2[i], s.isEmpty() ? -1: s.peek());
            s.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++)
        {
            res[i]= ngeMap.get(nums1[i]);
        }
        return res;           
           
    }
}