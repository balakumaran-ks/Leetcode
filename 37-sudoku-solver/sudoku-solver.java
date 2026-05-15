class Solution {
    public boolean isValid(char[][] board,int row,int col,char num){
        for(int iter=0;iter<9;iter++){
            if(board[iter][col]==num)return false;
            if(board[row][iter]==num)return false;
            if(board[3*(row/3)+iter/3][3*(col/3)+iter%3]==num)return false;
        }
        return true;
    }


    public boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c; // Put the number
                        
                        if (solve(board)) return true; // If it works, we're done!
                        
                        board[i][j] = '.'; // Otherwise, undo (backtrack)
                    }
                }
                return false; // None of the numbers 1-9 worked here
            }
        }
    }
    return true; // No empty cells left, Sudoku solved!
}

    public void solveSudoku(char[][] board) {
        solve(board);  
    }
}