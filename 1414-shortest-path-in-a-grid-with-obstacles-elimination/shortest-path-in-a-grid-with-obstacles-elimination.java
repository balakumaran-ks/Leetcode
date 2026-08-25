class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1) return 0;
        
        if (k >= m + n - 2) return m + n - 2;

        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            java.util.Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        int startK = grid[0][0] == 1 ? k - 1 : k;
        if (startK < 0) return -1;

        queue.add(new int[]{0, 0, startK});
        visited[0][0] = startK;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], rem = curr[2];

                if (r == m - 1 && c == n - 1) return steps;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        int nextK = rem - grid[nr][nc];

                        
                        if (nextK >= 0 && nextK > visited[nr][nc]) {
                            visited[nr][nc] = nextK;
                            queue.add(new int[]{nr, nc, nextK});
                        }
                    }
                }
            }
            steps++; 
        }

        return -1;
    }
}