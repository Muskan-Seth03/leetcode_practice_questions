class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList= new ArrayList<>();
        List<Integer> res= new ArrayList<>();

        for(int count=0; count <= rowIndex; count++)
        {
            List<Integer> currList=  new  ArrayList<>();
            if(count == 0)
            {
                currList.add(1); 
            }
            else
            {
                currList.add(1);
                int k=0;
                while(count > 1 && (k+1) < prevList.size())
                {
                    currList.add(prevList.get(k) + prevList.get(k+1));
                    k++;
                }
                currList.add(1);
            }
            prevList = currList;
        }
        res = prevList;
        return res;
        
    }
}