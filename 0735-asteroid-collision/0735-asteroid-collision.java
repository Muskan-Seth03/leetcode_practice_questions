// using stack
// TC: O(n)  SC: O(n)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n =  asteroids.length;
        
        Stack<Integer> s = new Stack<>();

        for(int a : asteroids)
        {
            while(!s.isEmpty() && s.peek() > 0 && a < 0)
            {
                int sum = s.peek() + a;

                if(sum < 0)
                {
                    s.pop();
                }
                else if(sum > 0)
                {
                    a = 0;
                }
                else if(sum == 0)
                {
                    s.pop();
                    a = 0;
                }
            }

            if(a != 0)
            s.push(a);
        }

        int l = s.size();
        int[] res = new int[l];

        int i = 1;
        while(!s.isEmpty())
        {
            res[l-i] = s.peek();
            i++;
            s.pop(); 
        }
        return res;
    }
}