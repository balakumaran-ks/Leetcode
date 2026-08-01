class Solution {
    List<List<Integer>> res;

    public void dfs(int[][] graph , int u , List<Integer> path,boolean[] visited){
        path.add(u);
        if(u==visited.length-1){
            visited[u] = false;
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int v:graph[u]){
            if(!visited[v]){
                visited[v]=true;
                dfs(graph,v,path,visited);
                visited[v]=false;
            }
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(graph,0, new ArrayList<>(),visited);
        return res;
    }
}