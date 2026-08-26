class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        //building adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //template
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            if(u==des)return true;
            for(int v:adjList.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        return false;
    }
}