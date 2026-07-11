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

class Pair{
    int skip;
    int take;
    Pair(int a,int b){
        skip = a;
        take = b;
    }
}

class Solution {

    public Pair solve(TreeNode node){
        if(node==null)return new Pair(0,0);
        Pair left = solve(node.left);
        Pair right = solve(node.right);

        int take = node.val+left.skip+right.skip;
        int skip = Math.max(left.take,left.skip)+Math.max(right.take,right.skip);

        return new Pair(skip,take);
    }

    public int rob(TreeNode root) {
        Pair res = solve(root);
        return Math.max(res.skip , res.take);
    }
}