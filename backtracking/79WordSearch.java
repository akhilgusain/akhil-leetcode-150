package backtracking;

class Solution {
    // global variables
    public char[][] board;
    public int rows;
    public int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        // iterate over the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backTrack(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(int row, int col, String word, int index) {
        if (index >= word.length()) { // word exist hence return true
            return true;
        }
        // check row and columns out of bounds and also current character should be the
        // one we want
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                this.board[row][col] != word.charAt(index)) {
            return false;
        }
        // now iterate over neighbours to continue
        int[] rowDir = { 0, 1, 0, -1 };
        int[] colDir = { 1, 0, -1, 0 };

        // to avoid checking same element twice we mark it as #
        this.board[row][col] = '#';

        boolean ret = false; // to keep track of return value
        for (int d = 0; d < 4; d++) {
            ret = backTrack(row + rowDir[d], col + colDir[d], word, index + 1);
            if (ret) {
                break;
            }
        }
        this.board[row][col] = word.charAt(index);// undo the hashing
        return ret;
    }
}