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

    int preOrderIndex;

    public TreeNode build(Map<Integer,Integer> map , int[] preorder, int[] inorder , int start , int end ){
        if(preOrderIndex>=preorder.length || start>=end || end<0 || start>=inorder.length)return null;
        int val = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(val);
        node.left = build(map,preorder,inorder,start,map.get(val));
        node.right = build(map,preorder,inorder,map.get(val)+1,end);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i); // mapping node to index
        }

        preOrderIndex = 0;

        TreeNode root = build(map,preorder,inorder,0,inorder.length);
        return root;
    }
}