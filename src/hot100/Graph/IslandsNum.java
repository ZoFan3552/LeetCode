package hot100.Graph;

import java.util.HashMap;

public class IslandsNum {
    int rowLen;
    int columnLen;
    public int numIslands(char[][] grid) {
        rowLen = grid.length;
        columnLen = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (grid[i][j] == '1'){
                    DFS(grid , i , j);
                    res++;
                }
            }
        }
        return res;
    }

    public void DFS(char[][] grid, int row, int column) {
        if (!(0 <= row && row < rowLen && 0 <= column && column < columnLen)){
            return;
        }
        if (grid[row][column] == '0') {
            return;
        }
        if (grid[row][column] == '1') {
            grid[row][column] = '0';
        }
        DFS(grid, row + 1, column);
        DFS(grid, row - 1, column);
        DFS(grid, row, column + 1);
        DFS(grid, row, column - 1);
    }

}