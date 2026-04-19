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
        if(node==null)return;
        //leaf node
        if(node.left==null && node.right==null){
            s.append(node.val);
            //convert to decimal
            this.sum += Integer.parseInt(s.toString(),2);
            s.deleteCharAt(s.length()-1);
            return;
        }
        //do
        s.append(node.val);

        helper(node.left,s);
        helper(node.right,s);

        //undo
        s.deleteCharAt(s.length()-1);
        return;
    }

    public int sumRootToLeaf(TreeNode root) {
        StringBuilder s = new StringBuilder(); //to store the path
        helper(root,s);
        return this.sum;
    }
}