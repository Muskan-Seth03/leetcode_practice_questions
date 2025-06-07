class Solution {  // TC:O(n^2)  SC:O(n)
    public int minMovesToMakePalindrome(String s) {
        char ch []= s.toCharArray();
        int n= s.length();
        int l= 0, r= n-1;
        int swapCount=0;

        while(l<r)
        {
            if (ch[l] == ch[r])
            {
                l++;
                r--;
            }
            else
            {
                int k= r;
                while(k >=l && ch[k] != ch[l])
                {
                    //find kro k th index ko jahan pe wo same ith char present hai
                    k--;
                }
                //no same char found , in case of odd length
                // k reaches l th index
                if(k == l)
                {
                    swap(ch, l, l+1);  // push that single char towards centre
                    swapCount++;
                }
                else
                {
                    // even length, match found
                    // Move ch[k] to position j via adjacent swaps
                    while(k<r) 
                    {
                        swap(ch, k, k+1);
                        swapCount++;
                        k++;
                    }
                    // problem fixed, decrease window size
                    l++;
                    r--; 
                }

            }
        }
        return swapCount;
    }

    public void swap(char ch[], int i, int j)
    {
        char temp= ch[i];
        ch[i]= ch[j];
        ch[j]= temp;
    }
}