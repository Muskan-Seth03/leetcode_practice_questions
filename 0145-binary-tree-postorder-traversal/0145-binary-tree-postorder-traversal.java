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
import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            TreeNode node = curr.node;
            boolean visited = curr.visited;

            if (node != null) {
                if (visited) {
                    res.add(node.val); // process node
                } else {
                    // Postorder: Left → Right → Node
                    stack.push(new Pair(node, true));    // mark node for processing
                    stack.push(new Pair(node.right, false)); // push right child
                    stack.push(new Pair(node.left, false));  // push left child
                }
            }
        }
        return res;
    }
}

// helper class to store (node, visited)
class Pair {
    TreeNode node;
    boolean visited;
    Pair(TreeNode node, boolean visited) {
        this.node = node;
        this.visited = visited;
    }
}
