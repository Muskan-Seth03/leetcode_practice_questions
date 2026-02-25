// TC: O(max(m, n))
// SC: O(max(m, n))
class Solution {
    public String reverse(String str)
    {
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
    public String addBinary(String a, String b) {
        int m= a.length() - 1;
        int n= b.length() - 1;

        int sum= 0;
        int carry= 0;
        String res= "";

        while(m>=0 || n>=0)
        {
            sum = carry;
            if(m >= 0)
            {
                sum += a.charAt(m) - '0';
                m--;
            }

            if(n >= 0)
            {
                sum += b.charAt(n) - '0';
                n--;
            }
            if(sum % 2 == 0) 
                res +='0';
            else
                res += "1";
            
            carry = sum > 1 ? 1 : 0;            
        }
        if(carry == 1)
        res += carry;
        return reverse(res);
    }
}