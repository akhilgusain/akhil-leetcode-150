package graphs;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length, n = board[0].length;
        // Mark boundary connected 0's with temporary character 'T'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // check boundary condition i.e if node is in boundary and is equal to 0
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        // Capture surrounded regions and revert T to O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // convert it to X since it is not marked as T
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T'; // Mark as visited
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
