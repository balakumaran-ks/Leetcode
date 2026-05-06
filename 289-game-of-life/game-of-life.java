class Solution {
    public int countAliveNeighbors(int[][] board, int row, int col) {
    int count = 0;
    int m = board.length;
    int n = board[0].length;

    // Relative coordinates for the 8 neighbors
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < 8; i++) {
        int r = row + dx[i];
        int c = col + dy[i];

        // Check boundaries and if the neighbor is alive
        // Note: Use (board[r][c] & 1) if you are solving in-place with state encoding
        if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1)) {
            count++;
        }
    }
    return count;
}
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] next = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    if(countAliveNeighbors(board,i,j)==2||countAliveNeighbors(board,i,j)==3)next[i][j]=true;
                }else{
                    if(countAliveNeighbors(board,i,j)==3)next[i][j]=true;
                }
            }
        }
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        board[i][j]=next[i][j]?1:0;
    }
}