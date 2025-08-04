// monotonic stack  TC: O(2N)  SC:O(N) + O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int res[]= new int[n];

        Stack<Integer>s=new Stack<>();
        for(int i= 2 * n-1; i>=0; i--)
        {
            int num= nums[i% n]; // circular array

            while(!s.isEmpty()  && s.peek() <= num)
            {
                s.pop();
            }
            if(i < n)
            {
                res[i]= (s.isEmpty() ? -1: s.peek());
            }
            s.push(num);
        }
       
        return res;             
    }
}