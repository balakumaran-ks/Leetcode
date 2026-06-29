class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        // Start the DFS with the left and right children at level 1 (odd)
        dfs(root.left, root.right, 1);
        return root;
    }

    private void dfs(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null) {
            return;
        }

        // If the current level is odd, swap the values directly
        if (level % 2 == 1) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        // Cruise down symmetrically:
        // Left child of node1 pairs with Right child of node2
        dfs(node1.left, node2.right, level + 1);
        // Right child of node1 pairs with Left child of node2
        dfs(node1.right, node2.left, level + 1);
    }
}