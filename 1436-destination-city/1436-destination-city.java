// M-1 using hashmap
// TC: O(n)  SC: O(n)
class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        Map<String, Integer> map= new HashMap<>();
        for(List<String> path : paths)
        {
            String src = path.get(0);
            String dest = path.get(1);

            map.put(src, 1);
        }
        String res = "";
        for(List<String> path : paths)
        {
            String src = path.get(0);
            String dest = path.get(1);
            if(!map.containsKey(dest))
            {
                res =  dest;
                break;
            }
        }
        return res;
    }
}