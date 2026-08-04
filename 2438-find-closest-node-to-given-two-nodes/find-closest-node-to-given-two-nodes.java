class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        // Calculate distances from node1
        getDistances(edges, node1, dist1);
        // Calculate distances from node2
        getDistances(edges, node2, dist2);

        int minMaxDist = Integer.MAX_VALUE;
        int resultNode = -1;

        // Find reachable node with minimum maximum distance
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    resultNode = i;
                }
            }
        }

        return resultNode;
    }

    private void getDistances(int[] edges, int startNode, int[] dist) {
        int current = startNode;
        int d = 0;
        
        while (current != -1 && dist[current] == -1) {
            dist[current] = d++;
            current = edges[current];
        }
    }
}