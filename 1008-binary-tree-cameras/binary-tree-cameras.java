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

    int cam;
    Set<TreeNode> covered;

    public void dfs(TreeNode node , TreeNode parent){
        if(node==null)return;
        dfs(node.left,node);
        dfs(node.right,node);

        if(parent==null && covered.contains(node)==false || covered.contains(node.left)==false || covered.contains(node.right)==false){
            cam++;
            covered.add(node);
            covered.add(parent);
            covered.add(node.left);
            covered.add(node.right);
        }
    }

    public int minCameraCover(TreeNode root) {
        cam = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root,null);
        return cam;
    }
}