class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = findHeight(root) - 1;
        int rows = height + 1;
        int cols = (int) Math.pow(2, height + 1) - 1;
        
        // Initialize the matrix with empty strings
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) row.add("");
            res.add(row);
        }
        
        // Fill the matrix using DFS
        fill(res, root, 0, 0, cols - 1);
        return res;
    }

    private void fill(List<List<String>> res, TreeNode node, int row, int left, int right) {
        if (node == null) return;
        
        int mid = left + (right - left) / 2;
        res.get(row).set(mid, Integer.toString(node.val));
        
        fill(res, node.left, row + 1, left, mid - 1);
        fill(res, node.right, row + 1, mid + 1, right);
    }

    private int findHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
}