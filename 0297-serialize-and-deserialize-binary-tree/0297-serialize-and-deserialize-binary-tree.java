/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC: O(n) for serialize/deserialize  
// SC: O(log n)/O(n) for building tree + O(n) for tokens array
public class Codec {
    private StringBuilder sb;

    private void dfs(TreeNode node) {
        if (node != null) {
            sb.append(node.val).append(",");
            dfs(node.left);

            dfs(node.right);
        } else {
            sb.append("N,");
            return;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();

        dfs(root);

        return sb.toString();
    }

    private int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // got sb , now deserialise
        String[] tokens = data.split(",");
        i = 0;
        return deserializeTree(tokens);
    }

    private TreeNode deserializeTree(String[] tokens) {
        if (tokens[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tokens[i++]));

        node.left = deserializeTree(tokens);
        node.right = deserializeTree(tokens);

        return node;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
