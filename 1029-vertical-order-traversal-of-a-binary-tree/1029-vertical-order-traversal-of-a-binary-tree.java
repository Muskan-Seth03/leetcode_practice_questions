/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //TC: O(N * log2N * log2N * log2N) ..... BFS ---> O(N) + Map operations O(log2N)*O(log2N).
 //SC:  O(N + N/2) map + queue storage
 class Tuple
 {
    TreeNode node;
    int start;
    int end;

    public Tuple(TreeNode node, int start,  int end)
    {
        this.node=node;
        this.start=start;
        this.end=end;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>map=
        new TreeMap<>();

        Queue<Tuple>q=new LinkedList<>();
        q.offer(new Tuple(root, 0,0));

        while(!q.isEmpty())
        {
            Tuple t= q.poll();
            TreeNode node= t.node;
            int x= t.start;
            int y= t.end;

            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left!=null)
            {
                q.offer(new Tuple(node.left, x-1, y));
            }
            if(node.right!=null)
            {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>>res= new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>>a : map.values())
        {
            List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer> queue: a.values())
            {
                while(!queue.isEmpty())
                {
                    list.add(queue.poll());
                }
            }
            res.add(list);
        }

        return res;
    }
}
