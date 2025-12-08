// TC: O(n^2)  SC: O(1)
class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int a=1; a<n; a++){
            for(int b=a+1; b<n; b++){
                int sumSq= (int)(Math.pow(a, 2) + Math.pow(b, 2));
                int c = (int)Math.sqrt(sumSq);

                // check if c is in the range
                if( c*c == sumSq && c<=n){
                    count+=2;
                }
            }
        }
        return count;
    }
}