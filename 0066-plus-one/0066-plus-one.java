// TC: O(n) SC: O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        int n= digits.length;
        int res[]= new int[n+1];
        if(digits[n-1] < 9)
        {
            digits[n-1] = digits[n-1] + 1;
            return digits;
        }
        // else
        int carry= 0;
        int i=n-1;
        if(digits[i] == 9)
        {
            carry = 1;
            digits[i]= 0;
            i--;
            while(carry != 0 && i >= 0)
            {
                if(digits[i] == 9)
                {
                    digits[i]=0;
                    carry =1;
                }               
                else if (digits[i] < 9)
                {
                   digits[i]= digits[i] + 1;
                   carry = 0;  
                } 
                i--;
            }
            // add carry at the front and shift all element to right by 1 position, return a new array 
            if(carry != 0)
            {
                res[0]= carry;
                for(int k=1; k<res.length; k++)
                {
                    res[k]= digits[k-1];
                }
                return res;
            }
            
        }
        return digits;
       
    }
}