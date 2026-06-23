class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map structure: Column -> Row -> Min-Heap (PriorityQueue) of values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Fill the map dynamically
        fill(root, map, 0, 0);
        
        List<List<Integer>> res = new ArrayList<>();
        
        // Iterate through the sorted columns
        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            
            // Iterate through the sorted rows in the current column
            for (PriorityQueue<Integer> pq : colMap.values()) {
                // The PriorityQueue automatically pops out the smallest values first
                while (!pq.isEmpty()) {
                    currentColumn.add(pq.poll());
                }
            }
            res.add(currentColumn);
        }
        
        return res;
    }

    // Updated fill method to populate the TreeMap
    private void fill(TreeNode node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int row, int col) {
        if (node == null) return;
        
        // Ensure the column exists
        map.putIfAbsent(col, new TreeMap<>());
        
        // Ensure the row exists within that column
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        
        // Add the value to the PriorityQueue (handles the sorting overlap constraint)
        map.get(col).get(row).add(node.val);
        
        // Traverse left (row + 1, col - 1)
        fill(node.left, map, row + 1, col - 1);
        
        // Traverse right (row + 1, col + 1)
        fill(node.right, map, row + 1, col + 1);
    }
}