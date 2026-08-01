class Solution {
    List<List<Integer>> res;

    public void dfs(int[][] graph , int u , List<Integer> path){
        path.add(u);
        if(graph.length-1==u){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int v:graph[u]){
                dfs(graph,v,path);
            
        }
        path.remove(path.size()-1);
    
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        res = new ArrayList<>();
        dfs(graph,0, new ArrayList<>());
        return res;
    }
}