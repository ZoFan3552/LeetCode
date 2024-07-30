package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/26 下午7:47
 */
public class BestTimeToBuyAndSellStockIV_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            // 当 k 大于等于 n/2 时，实际上相当于没有限制交易次数
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][][] dp = new int[n][k + 1][2];

        // 初始化 dp 数组
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        // 动态规划计算最大利润
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 返回最后一天结束时的最大利润（不持有股票的状态）
        int maxProfit = 0;
        for (int j = 0; j <= k; j++) {
            maxProfit = Math.max(maxProfit, dp[n - 1][j][0]);
        }

        return maxProfit;
    }
}
