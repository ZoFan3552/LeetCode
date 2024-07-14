package interview150.Graph;

public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length, n = board[0].length;
        boolean[][] canEscape = new boolean[m][n];

        // 从四条边发起DFS
        for (int i = 0; i < m; i++) {  // 处理上边和下边
            if (board[i][0] == 'O') DFS(board, i, 0, canEscape);
            if (board[i][n - 1] == 'O') DFS(board, i, n - 1, canEscape);
        }
        for (int j = 0; j < n; j++) {  // 处理左边和右边
            if (board[0][j] == 'O') DFS(board, 0, j, canEscape);
            if (board[m - 1][j] == 'O') DFS(board, m - 1, j, canEscape);
        }

        // 将未标记的'O'转换成'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!canEscape[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void DFS(char[][] board, int row, int col, boolean[][] canEscape) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] == 'X' || canEscape[row][col]) {
            return;
        }
        canEscape[row][col] = true;
        DFS(board, row + 1, col, canEscape);
        DFS(board, row - 1, col, canEscape);
        DFS(board, row, col + 1, canEscape);
        DFS(board, row, col - 1, canEscape);
    }

    public static void main(String[] args) {
        new SurroundedRegions_130().solve(new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}});
    }
}
