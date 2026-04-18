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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] digits = new int[10];
		return psudoHelper(root, digits);
    }
    private int psudoHelper(TreeNode node, int[] digits) {
		if (node == null)
			return 0;
		// condition check
		if (node.left == null && node.right == null) {
			int digitInd = node.val;

			// do
			digits[digitInd] = digits[digitInd] ^ 1;
			int res = 0;

			// calculate
			for (int digit : digits)
				res += digit;

			// backtrack
			digits[digitInd] = digits[digitInd] ^ 1;
			if (res <= 1)
				return 1;
			return 0;
		}
		int leftSum = 0;
		int rightSum = 0;
        int digitInd = node.val;
			digits[digitInd] = digits[digitInd] ^ 1;
		if (node.left != null) {
			leftSum = psudoHelper(node.left, digits);
			
		}
		if (node.right != null) {
			rightSum = psudoHelper(node.right, digits);
		}
        digits[digitInd] = digits[digitInd] ^ 1;
		return leftSum + rightSum;

	}

}