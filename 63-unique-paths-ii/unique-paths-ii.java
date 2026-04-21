class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] path = new int[row][col];
        for(int i=0;i<col;i++){
            if(grid[0][i]!=1)path[0][i]=1;
            else break;
        }
        for(int i=0;i<row;i++){
            if(grid[i][0]!=1)path[i][0]=1;
            else break;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(grid[i][j]!=1){
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }else
                path[i][j]=0;
            }
        }
        return path[row-1][col-1];
    }
}