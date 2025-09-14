/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC: O(N)  SC: O(N)
class Solution {
    private List<Integer> res;
    private Map<TreeNode, TreeNode> parent;

    private void buildParent(TreeNode root){   
        if(root == null)
        return;
        
        if(root.left != null)
        {
            parent.put(root.left, root);
            buildParent(root.left);
        }

        if(root.right!= null)
        {
            parent.put(root.right, root);
            buildParent(root.right);
        }
    }
    private void bfs(TreeNode target, int k){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(target);

        Set<TreeNode> set= new HashSet<>();
        set.add(target);

        while(!q.isEmpty())
        {
            int n= q.size();

            if(k==0)
            break;

            while(n!=0)
            {
                TreeNode node= q.poll();
                if(node.left != null && !set.contains(node.left))
                {
                    q.offer(node.left);
                    set.add(node.left);
                }
                if(node.right!= null && !set.contains(node.right))
                {
                    q.offer(node.right);
                    set.add(node.right);
                }
                if(parent.containsKey(node) && !set.contains(parent.get(node)))
                {
                    q.offer(parent.get(node));
                    set.add(parent.get(node));
                }
                n--;
            }
            k--;
        }
        while(!q.isEmpty())
        {
            res.add(q.poll().val);
        }  
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent= new HashMap<>();
        res=  new LinkedList<>();

        buildParent(root);

        bfs(target, k);
        return res;
    }
}