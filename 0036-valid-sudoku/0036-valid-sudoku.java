import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                // Skip empty cells
                if (number != '.') {
                    // Create unique string identifiers for row, column, and block
                    String rowKey = number + " in row " + i;
                    String colKey = number + " in col " + j;
                    String boxKey = number + " in block " + (i / 3) + "-" + (j / 3);
                    
                    // If any key already exists in the set, the board is invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
