class Solution {  // optimal approach  TC:O(n^2 * 26)==> O(n^2)  SC:O(1)
    public int beautySum(String s) {
        int n= s.length();
        int sum=0;
        for(int i=0; i<n; i++)
        {
            int freq[]= new int[26];
            for(int j=i; j<n; j++)
            {
                //generate substring  //count frequency
                //count beauty  //add to sum
                freq[s.charAt(j) - 'a']++;
                int max_freq = 0, min_freq = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++)
                {
                    if (freq[k] > 0)  //ignore if freq is zero, it means it is non existing. 
                    {
                        max_freq= Math.max(max_freq, freq[k]);
                        min_freq= Math.min(min_freq, freq[k]);
                    }
                }
                sum+= (max_freq - min_freq);
            }
        }
        return sum;
    }
}


             
               