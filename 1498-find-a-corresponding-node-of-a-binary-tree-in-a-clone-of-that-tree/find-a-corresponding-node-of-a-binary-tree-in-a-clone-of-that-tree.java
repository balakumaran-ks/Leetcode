/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    void helper(TreeNode node,TreeNode target,TreeNode[] arr){
        if(node.val==target.val) arr[0]=node;
        if(node.left!=null) helper(node.left,target,arr);
        if(node.right!=null) helper(node.right,target,arr);
        return ;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode node = cloned;
        TreeNode[] ans = new TreeNode[1];
        helper(node,target,ans);
        return ans[0];
    }
}