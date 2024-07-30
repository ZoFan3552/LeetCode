package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/24 上午11:36
 */
public class UniquePathsII_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //DFS超时，需使用动态规划
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];//dp[i][j]表示达到当前位置的路径数
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
