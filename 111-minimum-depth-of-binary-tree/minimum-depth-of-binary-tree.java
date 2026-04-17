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
    public int minDepth(TreeNode node) {
        if(node==null)return 0;
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        if(left==0||right==0)return Math.max(left,right)+1;
        return Math.min(left,right)+1;
    }
}