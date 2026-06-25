class Solution {

    public void dfs(char[][] grid,int x,int y,boolean[][] visited){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0' || visited[x][y]==true)return;
        visited[x][y]=true;
        dfs(grid,x-1,y,visited);
        dfs(grid,x+1,y,visited);
        dfs(grid,x,y+1,visited);
        dfs(grid,x,y-1,visited);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    res++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return res;
    }
}