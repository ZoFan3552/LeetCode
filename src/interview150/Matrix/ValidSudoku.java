package interview150.Matrix;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int row = 9, col = 9;
        //检查行
        for (int i = 0; i < row; i++) {
            int[] emuHash = new int[10];
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    if (emuHash[c] != 0) {
                        return false;
                    }else {
                        emuHash[c]++;
                    }
                }
            }
        }
        //检查列
        for (int i = 0; i < col; i++) {
            int[] emuHash = new int[10];
            for (int j = 0; j < row; j++) {
                char c = board[j][i];
                if (Character.isDigit(c)) {
                    if (emuHash[c] != 0) {
                        return false;
                    }else {
                        emuHash[c]++;
                    }
                }
            }
        }
        //检查 3x3
        for (int i = 0; i < row; i += 3) {
            for (int j = 0; j < col; j += 3) {
                int[] emuHash = new int[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char c = board[k][l];
                        if (Character.isDigit(c)) {
                            if (emuHash[c] != 0) {
                                return false;
                            }else {
                                emuHash[c]++;
                            }
                        }
                    }
                }
            }
        }


        return true;
    }
}
