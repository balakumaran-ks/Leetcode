class Solution {

    public void dfs(int n,boolean[] visited,int[][] matrix){
        visited[n]=true;
        for(int i=0;i<visited.length;i++){
            if(matrix[n][i]==1 && visited[i]==false){
                dfs(i,visited,matrix);
            }
        }
    }

    public boolean allVisit(boolean[] visited){
        for(boolean b:visited){
            if(b==false)return b;
        }
        return true;
    }

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[cities];
        int city = 0;
        while(allVisit(visited)==false){
            inner:
            for(int i=0;i<cities;i++)if(visited[i]==false){
                city=i;
                break inner;
                }
            dfs(city,visited,isConnected);
            provinces++;
        }
        return provinces;
    }
}