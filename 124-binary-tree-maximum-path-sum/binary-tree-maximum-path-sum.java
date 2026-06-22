class Solution {
    public int maxPathSum(TreeNode root) {
        // Use an array of size 1 to hold the global maximum reference
        int[] max = new int[] { Integer.MIN_VALUE };
        solve(root, max);
        return max[0];
    }

    public int solve(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        // Recursively get the max path sum of the left and right subtrees.
        // If a subtree returns a negative sum, we ignore it by taking 0 instead.
        int leftSum = Math.max(0, solve(node.left, max));
        int rightSum = Math.max(0, solve(node.right, max));

        // Calculate the maximum path sum that PEAKS at the current node (includes both sides)
        int currentMaxPath = node.val + leftSum + rightSum;
        
        // Update the global maximum if the current "peak" is greater
        max[0] = Math.max(max[0], currentMaxPath);

        // Return the max path sum that can be extended to the parent (can only choose one side)
        return node.val + Math.max(leftSum, rightSum);
    }
}