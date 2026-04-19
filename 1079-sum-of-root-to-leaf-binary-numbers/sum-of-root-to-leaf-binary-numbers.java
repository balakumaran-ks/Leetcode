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
    int sum = 0;

    void helper(TreeNode node,StringBuilder s){
        //leaf node
        if(node.left==null && node.right==null){
            s.append(node.val);
            //convert to decimal
            int num = Integer.parseInt(s.toString(),2);
            this.sum +=num;
            s.deleteCharAt(s.length()-1);
            return;
        }
        s.append(node.val);
        if(node.left!=null){
            helper(node.left,s);
        }
        if(node.right!=null){
            helper(node.right,s);
        }
        s.deleteCharAt(s.length()-1);
        return;
    }

    public int sumRootToLeaf(TreeNode root) {
        StringBuilder s = new StringBuilder(); //to store the path
        helper(root,s);
        return this.sum;
    }
}