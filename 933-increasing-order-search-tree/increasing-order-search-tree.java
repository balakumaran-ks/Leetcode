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
    public TreeNode increasingBST(TreeNode root) {
        if(root.left==null && root.right==null)return root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        while(root!=null || stack.isEmpty()==false){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.push(root);
            root = root.right;
        }
        root = res.pop();
        root.left=null;
        while(res.isEmpty()==false){
            TreeNode curr = res.pop();
            curr.left = null;
            curr.right = root;
            root = curr;
        }
        return root;
    }
}