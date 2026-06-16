class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m==1&&n==1){
            if(grid[0][0]==0)return 1;
            else return 0;
        }

        if(grid[0][0]==1)return 0;

        grid[0][0] = 1;
        
        //first row filling
        for(int col=1;col<n;col++){
            if(grid[0][col]==1){
                grid[0][col]=-1;
                continue;
            }
            grid[0][col] = grid[0][col-1];
        }

        //first col filling
        for(int row=1;row<m;row++){
            if(grid[row][0]==1){
                grid[row][0]=-1;
                continue;
            }
            grid[row][0] = grid[row-1][0];
        }

        //matrix filling
        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                if(grid[row][col]==1){
                    grid[row][col]=-1;
                    continue;
                }
                if(grid[row][col-1]==-1 && grid[row-1][col]==-1)continue;
                else if(grid[row][col-1]!=-1 && grid[row-1][col]!=-1){
                    grid[row][col] = grid[row][col-1] + grid[row-1][col];
                }
                else{
                    grid[row][col] = Math.max(grid[row][col-1] , grid[row-1][col]);
                }
            }
        }

        grid[m-1][n-1] = grid[m-1][n-1]==-1 ? 0 : grid[m-1][n-1];
        return grid[m-1][n-1];
    }
}