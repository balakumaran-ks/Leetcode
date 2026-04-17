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
    public void binaryTreePathsHelper(TreeNode node,StringBuilder s,List<String> list){
        if(node.left==null && node.right==null){
            s.append(node.val);
            list.add(s.toString());
            return;
        }
        s.append(node.val);
        if(node.left!=null){
            s.append("->");
            binaryTreePathsHelper(node.left,s,list);
            s.delete(s.lastIndexOf("->"),s.length());
        }
        if(node.right!=null){
            s.append("->");
            binaryTreePathsHelper(node.right,s,list);
            s.delete(s.lastIndexOf("->"),s.length());
        }
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        binaryTreePathsHelper(root,s,list);
        return list;
    }
}