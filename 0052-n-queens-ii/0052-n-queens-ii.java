class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;
        solve(0, 0, 0, 0, n);
        return count;
    }

    private void solve(int row, int cols, int diag1, int diag2, int n) {
        if (row == n) {
            count++;
            return;
        }

        // Available positions marked as 1 bits
        int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (availablePositions != 0) {
            // Get the lowest set bit (the first available spot)
            int position = availablePositions & -availablePositions;
            
            // Clear this bit from available positions
            availablePositions -= position;

            // Move to the next row with updated tracking masks
            solve(row + 1, cols | position, (diag1 | position) << 1, (diag2 | position) >> 1, n);
        }
    }
}
