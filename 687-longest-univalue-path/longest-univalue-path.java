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
    int nodeCount;

    public int helper(TreeNode node){
        if(node==null)return 0;
        int left = 0;
        if(node.left!=null && node.left.val==node.val)left = helper(node.left);
        int right = 0;
        if(node.right!=null && node.right.val==node.val)right = helper(node.right);
        nodeCount = Math.max(nodeCount,1+left+right);
        return 1+Math.max(left,right);
    }

    public void preorder(TreeNode node){
        if(node==null)return;
        helper(node);
        preorder(node.left);
        preorder(node.right);
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return 0;
        nodeCount = 0;
        preorder(root);
        return nodeCount-1;
    }
}