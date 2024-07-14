package hot100.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    private final List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] cheeseboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cheeseboard[i][j] = '.';
            }
        }
        backTracking(cheeseboard, 0, n, new ArrayList<>());
        return res;
    }

    public void backTracking(char[][] cheeseboard, int row, int n, List<String> board) {
        if (row == n) {
            for (char[] chars : cheeseboard) {
                board.add(new String(chars));
            }
            res.add(new ArrayList<>(board));
            board.clear();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (checkIsValid(cheeseboard, row, i, n)) {
                cheeseboard[row][i] = 'Q';
                backTracking(cheeseboard, row + 1, n, board);
                cheeseboard[row][i] = '.';
            }
        }
    }

    public boolean checkIsValid(char[][] cheeseboard, int curRow, int curCol, int n) {
//        //判断行是否出现皇后
//        for (int i = 0; i < n; i++) {
//            if (cheeseboard[curRow][i] == 'Q') {
//                return false;
//            }
//        }
        //判断列是否出现皇后
        for (int i = 0; i < curRow; i++) {
            if (cheeseboard[i][curCol] == 'Q') {
                return false;
            }
        }
        //判断斜角是否出现皇后
        //往右上
        for (int i = curRow - 1, j = curCol + 1; i >= 0 && j < n; i--, j++) {
            if (cheeseboard[i][j] == 'Q') {
                return false;
            }
        }
        //往左上
        for (int i = curRow - 1, j = curCol - 1; i >= 0 && j >= 0; i--, j--) {
            if (cheeseboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new N_Queens().solveNQueens(4);
        System.out.println(lists);
        System.out.println(lists.size());
    }
}
