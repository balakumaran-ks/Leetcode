class Solution {

    public int dfs(int[][] grid,boolean[][] visited , int m , int n , int row , int col){
        int area = 1;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int d=0;d<4;d++){
            int nr = row+dx[d];
            int nc = col+dy[d];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !visited[nr][nc]){
                visited[nr][nc] = true;
                area+=dfs(grid,visited,m,n,nr,nc);
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    res = Math.max(res, dfs(grid, visited, m, n, i, j));
                }
            }
        }
        return res;
    }
}