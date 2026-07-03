class NodeInfo {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private NodeInfo helper(TreeNode root) {
        // Base case: An empty tree is a valid BST
        if (root == null) {
            return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // 1. Traverse left and right subtrees (Bottom-Up)
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        // 2. Validate current node based on children's actual min/max values
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int currentSum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, currentSum);
            
            // Return min of this tree (handle if left is null) and max of this tree
            int currentMin = Math.min(root.val, left.min);
            int currentMax = Math.max(root.val, right.max);
            
            return new NodeInfo(true, currentMin, currentMax, currentSum);
        }

        // 3. If it's not a valid BST, mark it false (min/max don't matter anymore)
        return new NodeInfo(false, 0, 0, 0);
    }
}