class Solution {
    // Returns [cost_uncovered, cost_covered_no_camera, cost_has_camera]
    public int[] solve(TreeNode node) {
        if (node == null) {
            // A null node is already covered, can't have a camera, and doesn't need a parent
            return new int[]{0, 0, 99999}; // Use a large number to simulate infinity for invalid state
        }
        
        int[] left = solve(node.left);
        int[] right = solve(node.right);
        
        // State 0: Node is uncovered. Children must be safely covered (States 1 or 2).
        int uncovered = left[1] + right[1];
        
        // State 1: Node is covered, no camera. At least one child must have a camera (State 2).
        int coveredNoCamera = Math.min(
            left[2] + Math.min(right[1], right[2]), 
            right[2] + Math.min(left[1], left[2])
        );
        
        // State 2: Node has a camera. Children can be in any state.
        int hasCamera = 1 + Math.min(left[0], Math.min(left[1], left[2])) 
                          + Math.min(right[0], Math.min(right[1], right[2]));
        
        return new int[]{uncovered, coveredNoCamera, hasCamera};
    }

    public int minCameraCover(TreeNode root) {
        int[] res = solve(root);
        // The root cannot remain uncovered (State 0), so it must be either State 1 or State 2
        return Math.min(res[1], res[2]);
    }
}