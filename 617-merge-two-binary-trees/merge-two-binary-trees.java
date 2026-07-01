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
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if(node1==null && node2==null)return null;

        TreeNode node = null;
        if(node1!=null && node2!=null)node = new TreeNode(node1.val+node2.val);
        else if(node1==null)node = node2;
        else node = node1;
        if(node1!=null && node2!=null){
        node.left = mergeTrees(node1.left,node2.left);
        node.right = mergeTrees(node1.right,node2.right);}
        return node;
    }
}