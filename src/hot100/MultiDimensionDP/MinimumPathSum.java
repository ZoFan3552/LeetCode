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
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i - 1 >= 0 && j - 1 >= 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j] , dp[i][j-1]);
                }else {
                    if (i -1 >= 0){
                        dp[i][j] = grid[i][j] + dp[i-1][j];
                    }
                    if (j - 1 >= 0){
                        dp[i][j] = grid[i][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int res = new MinimumPathSum().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(res);
    }
}
