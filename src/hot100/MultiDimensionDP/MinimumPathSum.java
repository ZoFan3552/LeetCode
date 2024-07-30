package hot100.MultiDimensionDP;

public class MinimumPathSum {

    /*
        DFS，超时
        int res = Integer.MAX_VALUE;

        public int minPathSum(int[][] grid) {
            dfs(grid, 0, 0, 0);
            return res;
        }

        public void dfs(int[][] grid, int m, int n, int sum) {
            if (m >= grid.length || n >= grid[0].length) {
                return;
            }
            sum += grid[m][n];
            if (m == grid.length - 1 && n == grid[0].length - 1){
                res = Math.min(res, sum);
            }
            dfs(grid, m + 1, n, sum);
            dfs(grid, m, n + 1, sum);
        }
    */


    //使用动态规划
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 获取网格的行数
        int n = grid[0].length; // 获取网格的列数
        int[][] dp = new int[m][n]; // 创建一个二维数组 dp 来保存每个位置的最小路径和

        dp[0][0] = grid[0][0]; // 起始位置的路径和就是网格起始位置的值

        // 遍历网格的每个位置，计算到达每个位置的最小路径和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue; // 跳过起始位置，因为它已经初始化了
                }
                if (i - 1 >= 0 && j - 1 >= 0) { // 如果当前位置既可以从上方到达也可以从左方到达
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]); // 选择从上方或左方路径和较小的那个
                } else {
                    if (i - 1 >= 0) { // 如果当前位置只能从上方到达
                        dp[i][j] = grid[i][j] + dp[i-1][j]; // 当前路径和等于上方路径和加上当前格子的值
                    }
                    if (j - 1 >= 0) { // 如果当前位置只能从左方到达
                        dp[i][j] = grid[i][j] + dp[i][j-1]; // 当前路径和等于左方路径和加上当前格子的值
                    }
                }
            }
        }
        return dp[m-1][n-1]; // 返回到达右下角位置的最小路径和
    }

    public static void main(String[] args) {
        int res = new MinimumPathSum().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(res);
    }
}
