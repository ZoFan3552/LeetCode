package everyday.mid;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/20 下午12:45
 */
public class MinimumMovesToSpreadStonesOverGrid_2850 {
    public int minimumMoves(int[][] grid) {

        return dfs(grid,0,0);
    }
    public static int dfs(int[][] grid, int currentCol, int currentRow) {
        if (currentCol >= 3) {
            return 0;
        }
        if(currentRow >= 3) {
            return dfs(grid, currentCol + 1, 0);
        }

        if(grid[currentCol][currentRow] != 0) {
            return dfs(grid, currentCol, currentRow + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == currentCol && j == currentRow) {
                    continue;
                }
                if (grid[i][j] <= 1) {
                    continue;
                }
                grid[i][j] -= 1;
                res = Math.min(res, dfs(grid, currentCol, currentRow + 1) + Math.abs(i - currentCol) + Math.abs(j - currentRow));
                grid[i][j] += 1;
            }
        }
        return res;
    }
}
