//T.C : o(length)
//S.C : O(1)
class Solution {
    public int minPartitions(String n) {

        char maxCh = '0';

        for (char ch : n.toCharArray()) {
            maxCh = (char)Math.max(maxCh, ch);
        }

        return maxCh - '0';
    }
}