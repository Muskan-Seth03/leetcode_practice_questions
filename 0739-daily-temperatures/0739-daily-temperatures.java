// TC: O(n + m) SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;

        // logic for next greater element
        int[] NGE= new int[n];
        // from right to left
        Stack<Integer> s= new Stack();

        for(int i=n-1; i>=0; i--)
        {
            if(s.isEmpty())
            {
                NGE[i]= n;  // out of bound 
            }
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                NGE[i]= n;
            }
            else
            {
                NGE[i]= s.peek();
            }
            s.push(i);   
        }
        int[] res= new int[n];
        for(int i=0; i< n; i++)
        {
            res[i]= (NGE[i] == n)? 0: NGE[i] - i;
        }
        return res;
    }
}