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
    int paths = 0;

    public void dfs(TreeNode node,long runningSum,int targetSum,HashMap<Long,Integer> map){
        if(node==null)return;
        runningSum+=(long)node.val;
        paths+=map.getOrDefault(runningSum-targetSum,0);
        map.put(runningSum,map.getOrDefault(runningSum,0)+1);
        dfs(node.left,runningSum,targetSum,map);
        dfs(node.right,runningSum,targetSum,map);
        map.put(runningSum,map.getOrDefault(runningSum,0)-1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        //using prefix sum top-down dfs approach
        //if runningSum-targetSum appeared in prefix -> the current node is a valid path
        if(root==null)return 0;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0l,1);
        dfs(root,0,targetSum,map);
        return paths;
    }
}