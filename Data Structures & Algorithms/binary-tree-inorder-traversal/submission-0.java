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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;

        dfs(curr, inorder);
        return inorder;
    }

    private void dfs(TreeNode curr, List<Integer> inorder) {
        if(curr == null) {
            return;
        }

        dfs(curr.left, inorder);
        inorder.add(curr.val);
        dfs(curr.right, inorder);
    }
}