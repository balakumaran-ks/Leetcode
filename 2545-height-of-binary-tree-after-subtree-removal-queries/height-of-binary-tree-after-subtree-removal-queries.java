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

class Info{
    int height;
    int leftHeight;
    int rightHeight;
    Info(int left,int right){
        leftHeight = left;
        rightHeight = right;
    }
}

class Solution {

    public int helper(TreeNode node , Map<Integer,Info> map){
        if(node==null)return 0;
        int left = helper(node.left,map);
        int right = helper(node.right,map);
        map.put(node.val , new Info(left,right));
        return 1+Math.max(left,right);
    }

   public void height(TreeNode node, Map<Integer, Info> map, int depth, int maxWithoutCurrent) {
    if (node == null) return;

    // The maximum height of the tree if the current node is removed
    map.get(node.val).height = maxWithoutCurrent;

    // Fetch left and right child heights of the current node from your Info map
    Info currentInfo = map.get(node.val);
    int leftChildHeight = currentInfo.leftHeight;
    int rightChildHeight = currentInfo.rightHeight;

    // 1. Going LEFT:
    // If we delete the left child, the alternative path is either:
    // - The existing alternative path from above (maxWithoutCurrent)
    // - Or we go down the right sibling: current depth + rightChildHeight
    int maxIfLeftDeleted = Math.max(maxWithoutCurrent, depth + rightChildHeight);
    height(node.left, map, depth + 1, maxIfLeftDeleted);

    // 2. Going RIGHT:
    // If we delete the right child, the alternative path is either:
    // - The existing alternative path from above (maxWithoutCurrent)
    // - Or we go down the left sibling: current depth + leftChildHeight
    int maxIfRightDeleted = Math.max(maxWithoutCurrent, depth + leftChildHeight);
    height(node.right, map, depth + 1, maxIfRightDeleted);
}

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer,Info> map = new HashMap<>();
        helper(root,map);

        Info rootInfo = map.get(root.val);
    
    // If we go left, the right subtree is the alternative path (height = rootInfo.rightHeight)
    height(root.left, map, 1, rootInfo.rightHeight);
    
    // If we go right, the left subtree is the alternative path (height = rootInfo.leftHeight)
    height(root.right, map, 1, rootInfo.leftHeight);

        

        int[] res = new int[queries.length];
        for(int i=0;i<res.length;i++)res[i] = map.get(queries[i]).height;

        return res;
    }
}