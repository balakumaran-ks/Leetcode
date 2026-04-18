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

    public boolean helper(TreeNode node,int target,int sum){
        boolean l=false,r=false;
        if(node.right==null && node.left==null){
            if(target==(node.val+sum))return true;
            return false;
        }
        if(node.left!=null){
            l =  helper(node.left,target,sum+node.val);
        }
        if(node.right!=null){
            r =  helper(node.right,target,sum+node.val);
        }
        return l||r;
    }

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node==null)return false;
        return helper(node,targetSum,0);
    }
}