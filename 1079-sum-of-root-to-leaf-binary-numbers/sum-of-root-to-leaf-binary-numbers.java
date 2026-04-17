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
    public void helper(TreeNode node,int[] arr,StringBuilder s){
        if(node.left==null && node.right==null){
            s.append(node.val);
            arr[0]+= Integer.parseInt(s.toString(),2);
            s.deleteCharAt(s.length()-1);
            return;
        }
        if(node.left!=null){
            s.append(node.val);
            helper(node.left,arr,s);
            s.deleteCharAt(s.length()-1);
        }
        if(node.right!=null){
            s.append(node.val);
            helper(node.right,arr,s);
            s.deleteCharAt(s.length()-1);
        }
        return;
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)return root.val;
        int[] ans = new int[1];
        StringBuilder s = new StringBuilder();
        // ans[1] = root.val;
        helper(root,ans,s);
        return ans[0];
    }
}