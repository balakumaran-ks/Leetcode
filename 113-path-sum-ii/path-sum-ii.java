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

    public void helper(TreeNode node , int sum ,List<Integer> path ,List<List<Integer>> res ){
        if(node.left==null && node.right==null){
            if(sum==0)res.add(new ArrayList<>(path));
            return;
        }

        if(node.left!=null){
            path.add(node.left.val);
            helper(node.left,sum-node.left.val,path,res);
            path.remove(path.size()-1);
        }

        if(node.right!=null){
            path.add(node.right.val);
            helper(node.right,sum-node.right.val,path,res);
            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)return res;

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        // if((root.left==null && root.right==null) && root.val==targetSum){
        //     res.add(path);
        //     return res;
        //     }
        helper(root,targetSum-root.val,path,res);
        // helper(root.right,targetSum-root.val,path,res);
        return res;
    }
}