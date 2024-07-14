package everyday.mid;

public class CheckIfMoveIsLegal_1958 {
    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char anotherColor = color == 'W' ? 'B' : 'W';
        board[rMove][cMove] = color;
        return checkEndPoint(board, rMove, cMove, anotherColor);
    }

    public static boolean checkEndPoint(char[][] board, int row, int col , char anotherColor) {
        char curColor = board[row][col];
        //向上
        int up = row - 1;
        while (up >= 0 && board[up][col] == anotherColor) {
            up--;
        }
        if (up >= 0 && board[up][col] == curColor && up != row - 1) {
            return true;
        }
        int down = row + 1;
        while (down < board.length && board[down][col] == anotherColor) {
            down++;
        }
        if ( down < board.length && board[down][col] == curColor && down != row + 1) {
            return true;
        }
        //向左
        int left = col - 1;
        while (left >= 0 && board[row][left] == anotherColor) {
            left--;
        }
        if (left >= 0 && board[row][left] == curColor && left != col - 1) {
            return true;
        }
        //向右
        int right = col + 1;
        while (right < board[0].length && board[row][right] == anotherColor) {
            right++;
        }
        if (right < board[0].length && board[row][right] == curColor && right != col + 1) {
            return true;
        }
        //左上
        int leftUpRow = row - 1 , leftUpCol = col - 1;
        while (leftUpRow >= 0 && leftUpCol >= 0 && board[leftUpRow][leftUpCol] == anotherColor) {
            leftUpRow--;
            leftUpCol--;
        }
        if (leftUpRow >= 0 && leftUpCol >= 0 &&  board[leftUpRow][leftUpCol] == curColor && leftUpRow != row - 1 && leftUpCol != col - 1) {
            return true;
        }
        //右上
        int rightUpRow = row + 1 , rightUpCol = col + 1;
        while (rightUpRow < board.length && rightUpCol < board[0].length && board[rightUpRow][rightUpCol] == anotherColor) {
            rightUpRow++;
            rightUpCol++;
        }
        if (rightUpRow < board.length && rightUpCol < board[0].length && board[rightUpRow][rightUpCol] == curColor && rightUpRow != row + 1 && rightUpCol != col + 1) {
            return true;
        }
        //左下
        int leftDownRow = row + 1 , leftDownCol = col - 1;
        while (leftDownRow < board.length && leftDownCol >= 0 && board[leftDownRow][leftDownCol] == anotherColor) {
            leftDownRow++;
            leftDownCol--;
        }
        if (leftDownRow < board.length && leftDownCol >= 0 && board[leftDownRow][leftDownCol] == curColor && leftDownRow != row + 1 && leftDownCol != col - 1) {
            return true;
        }
        //右下
        int rightDownRow = row - 1 , rightDownCol = col + 1;
        while (rightDownRow >= 0 && rightDownCol < board[0].length && board[rightDownRow][rightDownCol] == anotherColor) {
            rightDownRow--;
            rightDownCol++;
        }
        if (rightDownRow >= 0 && rightDownCol < board[0].length && board[rightDownRow][rightDownCol] == curColor && rightDownRow != row - 1 && rightDownCol != col + 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'B', 'B', '.', '.', 'B', 'W', 'W', '.'},
                {'.', 'W', 'W', '.', 'B', 'W', 'B', 'B'},
                {'.', 'W', 'B', 'B', 'W', '.', 'W', '.'},
                {'B', '.', '.', 'B', 'W', 'W', 'W', '.'},
                {'W', 'W', 'W', 'B', 'W', '.', 'B', 'W'},
                {'.', '.', '.', 'W', '.', 'W', '.', 'B'},
                {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B'},
                {'W', '.', 'W', 'W', '.', 'B', '.', 'W'}
        };
        boolean res = checkMove(board, 2, 5, 'W');
        System.out.println(res);
    }
}
