package everyday.mid;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/14 下午6:33
 */
public class MaxIncreaseToKeepCitySkyline_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowsMax = new int[grid.length];
        int[] colsMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            rowsMax[i] = max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            colsMax[i] = max;
        }
        int totalIncremental = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxIncrement = Math.min(rowsMax[i], colsMax[j]);
                totalIncremental += maxIncrement - grid[i][j];
            }
        }
        return totalIncremental;
    }

}
