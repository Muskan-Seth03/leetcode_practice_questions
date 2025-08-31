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

//  Preorder, inorder, postorder traversal in one traversal.
import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null) return postorder;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair it = stack.pop();

            if(it.num == 1)
            {
                preorder.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.left!=null)
                {
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.num == 2)
            {
                inorder.add(it.node.val);
                it.num++;
                stack.push(it);

                if(it.node.right!=null)
                {
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else
            {
                postorder.add(it.node.val);
            }
        }
        return postorder;
    }
}

// helper class to store (node, visited)
class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
