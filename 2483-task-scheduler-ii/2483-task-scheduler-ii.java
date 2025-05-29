//TC: O(n)
//SC: O(n)
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n= tasks.length;
        HashMap<Integer, Long> map= new HashMap<>();
        long currDay=0;
        for(int task: tasks)
        {
            currDay++;
            long prev= map.getOrDefault(task, (long)-1 * space);

            if(currDay < (long) (prev + space + 1))
            currDay= (long) (prev + space + 1);

            map.put(task, currDay); 
        }
        return currDay;
    }
}
       