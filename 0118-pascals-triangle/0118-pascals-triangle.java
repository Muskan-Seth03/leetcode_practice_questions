// TC: O(n^2)  SC: O(n^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<Integer> prevList= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();

        for(int count=1; count <= numRows; count++)
        {
            List<Integer> currList=  new  ArrayList<>();
            if(count == 1)
            {
                currList.add(1); 
            }
            else
            {
                currList.add(1);
                int k=0;
                while(count > 2 && (k+1) < prevList.size())
                {
                    currList.add(prevList.get(k) + prevList.get(k+1));
                    k++;
                }

                currList.add(1);
            }
            res.add(currList);
            prevList = currList;
        }
        return res;
    }
}