package interview150.Matrix;

public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
        int[][] aroundCells = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                aliveCells(board , i , j , aroundCells);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1){
                    if (aroundCells[i][j] < 2 || aroundCells[i][j] > 3){
                        board[i][j] = 0;
                    }
                }else {
                    if (aroundCells[i][j] == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public void aliveCells(int[][] board , int row , int col , int[][] aroundCells){
        int aroundAliveCells = 0;
        if (row - 1 >= 0){//上
            if (board[row - 1][col] == 1 ){
                aroundAliveCells++;
            }
        }
        if (row - 1 >= 0 && col - 1 >= 0 ){//左上
            if (board[row - 1][col - 1] == 1){
                aroundAliveCells++;
            }
        }
        if (row + 1 < board.length ){//下
            if (board[row + 1][col] == 1){
                aroundAliveCells++;
            }
        }
        if (row + 1 < board.length && col + 1 < board[0].length ){//右下
            if (board[row + 1][col + 1] == 1){
                aroundAliveCells++;
            }
        }
        if (col - 1 >= 0 ){//左
            if (board[row][col - 1] == 1){
                aroundAliveCells++;
            }
        }
        if (row + 1 < board.length && col - 1 >= 0 ){//左下
            if (board[row + 1][col - 1] == 1){
                aroundAliveCells++;
            }
        }

        if (col + 1 < board[0].length ){//右
            if (board[row][col + 1] == 1){
                aroundAliveCells++;
            }
        }
        if (row - 1 >= 0 && col + 1 < board[0].length){//右上
            if (board[row - 1][col + 1] == 1){
                aroundAliveCells++;
            }
        }
        aroundCells[row][col] = aroundAliveCells;
    }

    public static void main(String[] args) {
        new GameOfLife_289().gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
