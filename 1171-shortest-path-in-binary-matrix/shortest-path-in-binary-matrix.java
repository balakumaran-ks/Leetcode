import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // Edge case: start or end is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }

        // 8-directional movements
        int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

        // Use ArrayDeque and primitive arrays
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
        // Reusing the grid array as the visited set to save O(N^2) space
        grid[0][0] = 1; 
        int pathLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process current layer completely
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == n - 1 && c == n - 1) {
                    return pathLength;
                }

                for (int i = 0; i < 8; i++) {
                    int x = r + dr[i];
                    int y = c + dc[i];

                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1; // Mark as visited immediately
                        queue.add(new int[]{x, y});
                    }
                }
            }
            pathLength++;
        }

        return -1;
    }
}