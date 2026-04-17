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
    public int sumOfLeftLeavesHelper(TreeNode node , boolean isLeft,int[] sum){
        if(node.left==null && node.right==null){
            if(isLeft) sum[0]+= node.val;
            return 0;
        }
        if(node.left!=null)sumOfLeftLeavesHelper(node.left,true,sum);
        if(node.right!=null)sumOfLeftLeavesHelper(node.right,false,sum);
        return sum[0];
    }

    public int sumOfLeftLeaves(TreeNode node) {
        if(node==null)return 0;
        if(node.left==null && node.right==null)return 0;
        int[] sum = new int[1];
        return sumOfLeftLeavesHelper(node , false,sum);
    }
}