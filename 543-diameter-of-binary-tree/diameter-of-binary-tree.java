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

    int maxi;

    public int helper(TreeNode node){
        if(node==null)return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        maxi = Math.max(maxi,l+r);
        return 1+Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0;
        helper(root);
        return maxi;
    }
}