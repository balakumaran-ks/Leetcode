class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int topRow;
        int bottomRow;
        topRow = 0;
        bottomRow = n-1;
        // 1. Reverse Vertically (Swap Row 0 with Row N-1, etc.)
        while (topRow < bottomRow) {
            int[] temp = matrix[topRow]; // No need to .clone()
            matrix[topRow] = matrix[bottomRow];
            matrix[bottomRow] = temp;
            topRow++;
            bottomRow--;
        }

        // 2. Transpose (Swap across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Start at i + 1 to avoid double-swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}