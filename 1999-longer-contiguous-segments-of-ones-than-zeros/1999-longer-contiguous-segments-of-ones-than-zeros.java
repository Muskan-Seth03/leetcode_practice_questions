class Solution {
    public boolean checkZeroOnes(String s) {
        char []charArray= s.toCharArray();
        int maxOnes= 0, countOnes=0;
        int maxZeros=0, countZeros=0;
        for(int i=0; i<charArray.length-1; i++)
        {
            if(charArray[i]== '1')
            {
                countOnes++;
                if(charArray[i+1]!='1')
                {
                    maxOnes= Math.max(maxOnes, countOnes);
                    countOnes=0;
                }
            }

            else if(charArray[i]== '0')
            {
                countZeros++;
                if(charArray[i+1]!='0')
                {
                    maxZeros= Math.max(maxZeros, countZeros);
                    countZeros=0;
                }
            }  
        }    
        // handle last segment
        if (charArray[charArray.length - 1] == '1')
        {
            countOnes++;
            maxOnes = Math.max(maxOnes, countOnes);
        }
        else
        {
            countZeros++;
            maxZeros = Math.max(maxZeros, countZeros);
        }

        return maxOnes > maxZeros;
    }
}