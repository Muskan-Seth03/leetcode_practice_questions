// TC: O(m*n) SC: O(n)
class Solution {
    public int[] getNSR(int[] height)
    {
        int n= height.length;
        Stack<Integer> s= new Stack<>();
        int[] nsr= new int[n];

        for(int i= n-1; i>=0; i--)
        {
            if(s.isEmpty())
            {
                nsr[i]= n;
            }
            else
            {
                while(!s.isEmpty() && height[s.peek()] >= height[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    nsr[i]= s.peek();
                }
                else
                {
                    nsr[i]= n;
                }
            }
            s.push(i);
        }
        return nsr;
    }
    public int[] getNSL(int[] height)
    {
        int n= height.length;
        Stack<Integer> s= new Stack<>();
        int[] nsl= new int[n];

        for(int i= 0; i < n; i++)
        {
            if(s.isEmpty())
            {
                nsl[i]= -1;
            }
            else
            {
                while(!s.isEmpty() && height[s.peek()] >= height[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    nsl[i]= s.peek();
                }
                else
                {
                    nsl[i]= -1;
                }
            }
            s.push(i);
        }
        return nsl;
    }

    public int findMaxArea(int[] height)
    {
        int area=0;
        int maxArea=0;
        int n= height.length;
        // area= width * height
        // find nsr and nsl for width[i]

        int[] NSR= getNSR(height);
        int[] NSL= getNSL(height);

        int[] width= new int[n];
        for(int i=0; i<n; i++)
        {
            width[i]= NSR[i] - NSL[i] - 1;
        }
        for(int i=0; i<n; i++)
        {
            area= height[i] * width[i];
            maxArea= Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;

        // add row=0 in height 1-D
        int[] height= new int[n];
        
        for(int i=0; i<n; i++)
        {
            height[i]= matrix[0][i] == '1'? 1 : 0;
        }
        int maxArea= findMaxArea(height);
        // find the max area from the 1 d array

        for(int row=1; row < m; row++)
        {
            for(int col= 0; col < n; col++)
            {
                if(matrix[row][col] == '0')
                height[col]= 0;
                else
                height[col] = height[col] + 1;
            }
            maxArea= Math.max(maxArea, findMaxArea(height));
        }
        return maxArea;
    }
}