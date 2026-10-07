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
    public int kthSmallest(TreeNode root, int k) {
        
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int smallest = 1;

        while(curr != null || !stack.isEmpty()) {

            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            index++;

            if(index == k) {
                smallest = curr.val;
                break;
            }


            curr = curr.right;
        }

        return smallest;
    }
}
