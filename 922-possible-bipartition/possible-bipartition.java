class Solution {
    public boolean possibleBipartition(int n, int[][] edges) {
        boolean[][] adj = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = true;
            adj[edge[1]][edge[0]] = true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int color = 0;
        int[] colored = new int[n + 1];
        Arrays.fill(colored, -1);
        for (int i = 1; i <= n; i++) {
            if (colored[i] != -1)
                continue;

            colored[i] = 0; // Start the component with color 0
            queue.add(i);

            // Use a while loop to ensure the entire connected component is explored
            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v = 1; v <= n; v++) {
                    if (adj[u][v]) {
                        if (colored[v] == -1) {
                            // Assign the opposite color of the parent node 'u'
                            colored[v] = 1 - colored[u];
                            queue.add(v);
                        } else if (colored[v] == colored[u]) {
                            // If a neighbor has the same color, it's not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}