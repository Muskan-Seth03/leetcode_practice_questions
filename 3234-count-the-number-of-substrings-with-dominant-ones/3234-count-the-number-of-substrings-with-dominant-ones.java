//Approach (Improving the brute force by skipping index j wherever possible)
//T.C : Worst case O(n^2), but since we skip indices we get O(n*sqrt(n))    
//S.C : O(n)

// TC : O(n * n) worst
// O(n * ?)
// j - i + 1 = L
// L^2 ----> ~ n
// L = sqrt*(n)
// O(n * sqrt(n)) — best case

class Solution {
    public int numberOfSubstrings(String s) {
        int n= s.length();
        // find the cumulative sum of ones
        int[] cumCountOne = new int[n];

        cumCountOne[0] = s.charAt(0) == '1'? 1 : 0;

        for(int i=1; i < n; i++)
        {
            if(s.charAt(i) == '1')
            {
                cumCountOne[i] = cumCountOne[i-1] + 1;
            }
            else
            {
                cumCountOne[i] = cumCountOne[i-1] + 0;
            }
        }

        int res = 0;
        for(int i= 0; i < n; i++)
        {
            for(int j= i; j < n; j++)
            {
                // find count of one and zero from i to j
                int oneCount = cumCountOne[j] - ((i-1) >= 0? cumCountOne[i-1] : 0);
                int zeroCount = (j - i + 1) - oneCount;

                if((zeroCount * zeroCount) > oneCount)
                {
                    int needOne = (zeroCount * zeroCount) - oneCount;
                    // skip j by needOne positions
                    j += needOne - 1;    // -1 due to j++ of for loop, we cant skip 
                }
                else if ((zeroCount * zeroCount) == oneCount)
                {
                    res += 1;
                }
                else
                {
                    //[i...j] valid substring
                    res += 1;
                    //(zeroCount * zeroCount) < oneCount)
                    int safeToShift = (int) Math.sqrt(oneCount) - zeroCount;
                    int nextj = j + safeToShift;

                    if(nextj >= n)  
                    // out of bound then all the mid  number can be part of substring
                    {
                        res += n - 1 - j;
                        break;
                    }
                    res += safeToShift;
                    j = nextj;
                }
            }
        }
        return res;
    }
}