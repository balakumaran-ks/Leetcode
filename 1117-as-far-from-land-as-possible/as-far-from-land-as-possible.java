class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int land = 0;
        int water = 0;
        int res = -1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)water++;
                else{
                    land++;
                    grid[i][j]=-1;
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(land==0 || water==0)return -1;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int d=0;d<4;d++){
                int nr = r+dx[d];
                int nc = c+dy[d];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    queue.add(new int[]{nr,nc});
                    if(grid[r][c]==-1)grid[nr][nc]=1;
                    else
                    grid[nr][nc] = grid[r][c]+1;
                    res = Math.max(res,grid[nr][nc]);
                }
            }
        }
        return res;
    }
}