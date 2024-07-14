package hot100.BackTrack;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(DFS(board , word , 0 , visited , i,  j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, String word, int targetIndex, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (board[row][col] == word.charAt(targetIndex)) {
            if (targetIndex == word.length() - 1){
                return true;
            }
        }else {
            visited[row][col] = false;
            return false;
        }

        if(DFS(board, word, targetIndex + 1, visited, row, col - 1)){
            return true;
        }
        if(DFS(board, word, targetIndex + 1, visited, row, col + 1)){
            return true;
        }
        if(DFS(board, word, targetIndex + 1, visited, row - 1, col)){
            return true;
        }
        if(DFS(board, word, targetIndex + 1, visited, row + 1, col)){
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        boolean exist = new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        System.out.println(exist);
    }
}
