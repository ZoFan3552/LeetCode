package everyday;

public class BattleshipsinaBoard_419 {
    public int countBattleships(char[][] board) {
        //使用战舰头部来判断
        int m = board.length;
        int n = board[0].length;
        int shipNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i -1 >= 0){
                    if (board[i -1][j] == 'X'){
                        continue;
                    }
                }
                if (j - 1 >= 0){
                    if (board[i][j - 1] == 'X'){
                        continue;
                    }
                }
                shipNum++;
            }
        }
        return shipNum;
    }
}
