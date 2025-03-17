class Solution {   //using stack 
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> s = new Stack<>();

        for (int[] interval : intervals) {
            if (s.isEmpty() || s.peek()[1] < interval[0]) 
            {
                // No overlap, push interval
                s.push(interval);
            } 
            else 
            {
                // Merge intervals (update top element of stack)
                s.peek()[1] = Math.max(s.peek()[1], interval[1]);
            }
        }

        return s.toArray(new int[s.size()][]);
    }
}