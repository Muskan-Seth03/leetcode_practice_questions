class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid > 0 && letters[mid-1] <= target && letters[mid]> target){
                return letters[mid];
            }
            else if(letters[mid] > target){
                   end = mid -1;
            }
            else{
                start = mid +1 ;
            }
        }
       return letters[0];
    }
}