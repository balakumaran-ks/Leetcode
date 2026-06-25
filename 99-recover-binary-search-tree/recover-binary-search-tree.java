class Solution {
    // Keep track of the two swapped nodes and the previously visited node
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Travel through the tree in sorted order
        inorder(root);
        
        // Swap the values of the two mismatched nodes back
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // 1. Traverse Left
        inorder(node.left);

        // 2. Process Current Node: Look for out-of-order pairs
        if (prev != null && prev.val > node.val) {
            // First time seeing a dip? 'prev' is our first misplaced node
            if (first == null) {
                first = prev;
            }
            // 'node' is always a candidate for the second misplaced node
            second = node;
        }
        // Progress the 'prev' tracking pointer forward
        prev = node;

        // 3. Traverse Right
        inorder(node.right);
    }
}