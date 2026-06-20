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

    int k;

    void helper(TreeNode node,int[] ans){
            if(node==null)return;
            helper(node.left,ans);
            k--;
            if(k==0){
                ans[0] = node.val;
                return;
            }
            helper(node.right,ans);
        }
    
    public int kthSmallest(TreeNode root, int n) {
        int[] ans = new int[1];
        k=n;
        helper(root,ans);
        return ans[0];
    }
}