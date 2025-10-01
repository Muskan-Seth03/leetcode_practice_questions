// TC: O(n^2)  SC: O(n)
class Solution {
    private String faulty(String str)
    {
        while(str.contains("i"))   // suppose no of "i" ===> k  ..loop runs k times 
        {
            int ind= str.indexOf('i');   //O(n) time
            String prefix= str.substring(0, ind);
            String suffix= str.substring(ind + 1);  // O(n) space

            //reverse prefix and then concat
            char cArray[]= prefix.toCharArray();  // O(n) space

            int i= 0, j= cArray.length -1;
            while(i < j)
            {
                char temp= cArray[i];
                cArray[i]= cArray[j];
                cArray[j]= temp;
                i++;
                j--;
            } 
            str= new String(cArray).concat(suffix);  // O(n) space
        }   
        return str;
    }
    public String finalString(String s) {
        return faulty(s);
    }
}