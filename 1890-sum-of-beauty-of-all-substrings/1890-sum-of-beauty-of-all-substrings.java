class Solution {  // better approach  TC:O(n^2 * 26)==> O(n^2)  SC:O(1)
    public int getMax(int freq[])
    {
        int max_value= 0;
        for(int i=0; i<26; i++)
        {
            max_value= Math.max(max_value, freq[i]);
        }
        return max_value;
    }
    public int getMin(int freq[])
    {
        int min_value= Integer.MAX_VALUE;
        for(int i=0; i<26; i++)
        {
            if(freq[i]!=0)   //ignore if freq is zero, it means it is non existing. 
            min_value= Math.min(min_value, freq[i]);
        }
        return min_value;
    }
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
                int beauty= getMax(freq) - getMin(freq); 
                sum+= beauty;
            }
        }
        return sum;
    }
}