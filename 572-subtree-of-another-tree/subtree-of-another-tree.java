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
    public boolean isSame(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null)return true;
        if((node1==null && node2!=null) || (node1!=null && node2==null))return false;
        if(node1.val!=node2.val)return false;
        return isSame(node1.left,node2.left) && isSame(node1.right,node2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)return true; 
        boolean res = false;
        if((root==null && subRoot!=null)||(root!=null && subRoot==null))return false;
        if(root.val==subRoot.val){
            res = isSame(root,subRoot);
        } 
        return (isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot)) || res;
    }
}