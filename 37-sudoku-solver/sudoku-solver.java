class Solution {

    public boolean isValid(char[][] board,int row,int col,char num){
        for(int iter=0;iter<9;iter++){
            if(board[iter][col]==num)return false;
            if(board[row][iter]==num)return false;
            if(board[3*(row/3)+iter/3][3*(col/3)+iter%3]==num)return false;
        }
        return true;
    }

   boolean wrapper(char[][] board) {
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num;
                        
                        if (wrapper(board)) return true; // Move to next empty cell
                        
                        board[row][col] = '.'; // Backtrack
                    }
                }
                return false; // Tried 1-9, none worked, go back and change previous cell
            }
        }
    }
    return true; // No empty cells left!
}

    public void solveSudoku(char[][] board) {
        wrapper(board);
    }
}