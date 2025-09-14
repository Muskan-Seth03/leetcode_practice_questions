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
// TC: O(N) SC: O(N)
class Solution {
    private Map<TreeNode, TreeNode> parent;
    int count;

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
    
    private void bfs(TreeNode target){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(target);

        Set<TreeNode> set= new HashSet<>();
        set.add(target);

        while(!q.isEmpty())
        {
            int n= q.size();
            
            boolean infected= false;
            
            while(n!=0)
            {
                TreeNode node= q.poll();
                if(node.left != null && !set.contains(node.left))
                {
                    q.offer(node.left);
                    set.add(node.left);
                    infected= true;
                }
                if(node.right!= null && !set.contains(node.right))
                {
                    q.offer(node.right);
                    set.add(node.right);
                    infected= true;
                }
                if(parent.containsKey(node) && !set.contains(parent.get(node)))
                {
                    q.offer(parent.get(node));
                    set.add(parent.get(node));
                    infected= true;
                }
                n--;
            }
            if(infected) count++;  // burned signifies that there is a new level that contains noded to be infected 
        }
    }

    private TreeNode findTarget(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        TreeNode left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
    public int amountOfTime(TreeNode root, int start) {
        parent= new HashMap<>();
        count=0;
        
        TreeNode targetNode= findTarget(root, start);
        if(targetNode== null)
        return 0;

        buildParent(root);

        bfs(targetNode);
        return count;
    }
}