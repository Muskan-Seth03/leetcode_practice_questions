// TC: O(n)  SC:O(n)
class Solution {
    public int bestClosingTime(String customers) {
        int n= customers.length();

        int[] prefixSum= new int[n+1];
        int[] suffixSum= new int[n+1];

        for(int i=0; i<n; i++)
        {
            if(customers.charAt(i) == 'N')
            {
                prefixSum[i+1]= prefixSum[i] + 1;
            }
            else
            {
                prefixSum[i+1]= prefixSum[i] ;
            }
        }  
        for(int i=n-1; i>=0; i--)
        {
            if(customers.charAt(i) == 'Y')
            {
                suffixSum[i]= suffixSum[i+1] + 1;
            }
            else
            {
                suffixSum[i]= suffixSum[i+1] ;
            }
        }                 

        int penalty= 0;
        int minPenalty= Integer.MAX_VALUE;
        int bestTime=0;
        for(int j=0; j<n+1; j++)
        {
            penalty = prefixSum[j] + suffixSum[j];
            if(penalty < minPenalty)
            {
                minPenalty= penalty;
                bestTime= j;
            }
        }
        return bestTime;
    }
}