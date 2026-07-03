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

    public void dfs(TreeNode node,List<Integer> list){
        if(node==null)return;
        list.add(node.val);
        dfs(node.left,list);
        dfs(node.right,list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1,res);
        dfs(root2,res);
        Collections.sort(res);
        return res;
    }
}