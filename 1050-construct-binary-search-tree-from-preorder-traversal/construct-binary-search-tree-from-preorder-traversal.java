class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstHelper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstHelper(int[] preorder, int bound) {
        // If we processed all elements or the current element exceeds the valid BST bound
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }

        // The current element is the root of this subtree
        TreeNode root = new TreeNode(preorder[index++]);

        // Left children must be smaller than the current root's value
        root.left = bstHelper(preorder, root.val);

        // Right children can be anything up to the parent's maximum allowed bound
        root.right = bstHelper(preorder, bound);

        return root;
    }
}