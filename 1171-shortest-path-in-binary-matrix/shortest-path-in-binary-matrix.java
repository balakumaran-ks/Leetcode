class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        int[] dr = {0,0,1,-1,1,1,-1,-1};
        int[] dc = {1,-1,0,0,1,-1,1,-1};

        int n = grid.length;
        if(n==1 && grid[0][0]==0)return 1;

        int[][] dist = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] arr = queue.poll(); // arr = [row , col]
            int r = arr[0];
            int c = arr[1];
            for(int i=0;i<8;i++){
                int x = r+dr[i];
                int y = c+dc[i];
                if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0 && dist[x][y]==0){
                    // visited[x][y] = true;
                    dist[x][y] = dist[r][c]+1;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return dist[n-1][n-1]>0 ? dist[n-1][n-1]+1 : -1;
    }
}