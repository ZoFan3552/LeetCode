package everyday;

public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        //本题使用的是区间DP，即大区间可以由小区间的值得到
        int n = nums.length;
        // 创建一个新的数组，包含两个边界的虚拟气球
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        // 创建 dp 表，初始化为 0
        int[][] dp = new int[n + 2][n + 2];

        // 填充 dp 表，从长度为 1 的区间开始，逐步扩大到整个区间
        for (int length = 1; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                // 计算 dp[i][j]，考虑最后一个被戳的气球是哪一个
                for (int k = i; k <= j; k++) {
                    //因为第 k 个气球是最后一个被戳破的，所以此时 i , k , j 是相邻的
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k-1] + newNums[i-1] * newNums[k] * newNums[j+1] + dp[k+1][j]);
                }
            }
        }

        // 最终结果存储在 dp[1][n] 中
        return dp[1][n];
    }
}
