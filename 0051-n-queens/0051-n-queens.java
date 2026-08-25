import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[] cols;
    private boolean[] diag1; // Top-left to bottom-right diagonals
    private boolean[] diag2; // Top-right to bottom-left diagonals

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(0, n, board);
        return result;
    }

    private void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place Queen
                board[row][col] = 'Q';
                cols[col] = diag1[d1] = diag2[d2] = true;

                // Move to next row
                backtrack(row + 1, n, board);

                // Backtrack
                board[row][col] = '.';
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
