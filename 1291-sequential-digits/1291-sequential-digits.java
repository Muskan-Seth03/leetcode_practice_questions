// TC: O(n)   SC: O(n)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=8; i++)
        {
            q.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp = q.poll();

            if(temp >= low && temp <= high)
            res.add(temp);

            int lastDigit = temp % 10;

            if(lastDigit + 1 <= 9)
            {
                int nextNumber = (temp * 10) + (lastDigit + 1); 
                q.offer(nextNumber);
            }
        }
        return res;
    }
}