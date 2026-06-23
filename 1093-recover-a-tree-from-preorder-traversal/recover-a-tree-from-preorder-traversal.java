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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i=0;
        int n = traversal.length();

        while(i<n){

            int depth=0;
            while(i<n && traversal.charAt(i)=='-' ){
                i++;
                depth++;
            }

            int val = 0;

            while(i<n && Character.isDigit(traversal.charAt(i))){
                val = val*10 + (traversal.charAt(i)-'0');
                i++;
            }

            TreeNode curr = new TreeNode(val);
            while(stack.size()>depth){
                stack.pop();
            }
            if(stack.size()>0){
            if(stack.peek().left==null)stack.peek().left=curr;
            else stack.peek().right=curr;}
            stack.push(curr);
        }
        while(stack.size()>1)stack.pop();
        return stack.peek();
    }
}