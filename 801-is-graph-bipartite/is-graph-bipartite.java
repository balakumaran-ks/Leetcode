class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        // 0 --> unvisited
        // 1 --> red
        // 2 --> black
        Arrays.fill(color, -1);
        for (int s = 0; s < n; s++) {
            if (color[s] != -1)
                continue;
            color[s] = 0;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(s);
            while(q.isEmpty()==false){
                int u = q.poll();
                for(int v:graph[u]){
                    if(color[v]==-1){
                        color[v] = 1 - color[u];
                        q.add(v);
                    }else if(color[v]==color[u])return false;
                }
            }
        }

        return true;
    }
}