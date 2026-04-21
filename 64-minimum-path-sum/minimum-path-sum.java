class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minPath = new int[row][col];
        minPath[0][0] = grid[0][0];
        for(int i=1;i<col;i++){
            minPath[0][i] = minPath[0][i-1]+grid[0][i];
        }
        for(int i=1;i<row;i++){
            minPath[i][0] = minPath[i-1][0]+grid[i][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                minPath[i][j] = grid[i][j]+Math.min(minPath[i-1][j],minPath[i][j-1]);
            }
        }
        return minPath[row-1][col-1];
    }
}