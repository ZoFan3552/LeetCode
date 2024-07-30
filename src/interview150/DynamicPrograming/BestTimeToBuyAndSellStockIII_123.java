package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/26 下午7:26
 */
public class BestTimeToBuyAndSellStockIII_123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp数组，三维：天数，是否持股，卖出的次数
        int[][][] dp = new int[n][2][3];

        // 初始化第一天的状态
        dp[0][0][0] = 0;  // 未持股，未卖出过股票
        dp[0][0][1] = 0;  // 未持股，卖出过1次股票（第一天不可能卖出）
        dp[0][0][2] = 0;  // 未持股，卖出过2次股票（第一天不可能卖出）
        dp[0][1][0] = -prices[0];  // 持股，未卖出过股票（第一天买入）
        dp[0][1][1] = Integer.MIN_VALUE;  // 持股，卖出过1次股票（第一天不可能既买又卖）
        dp[0][1][2] = Integer.MIN_VALUE;  // 持股，卖出过2次股票（第一天不可能既买又卖）

        for (int i = 1; i < n; i++) {
            // 未持股，未卖出过股票
            dp[i][0][0] = dp[i - 1][0][0];
            // 未持股，卖出过1次股票
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            // 未持股，卖出过2次股票
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            // 持股，未卖出过股票
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            // 持股，卖出过1次股票
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            // 持股，卖出过2次股票，这种情况不存在
            dp[i][1][2] = Integer.MIN_VALUE;
        }

        // 最后一天结束时，可能的最大利润情况
        return Math.max(dp[n - 1][0][1], dp[n - 1][0][2]);
    }
}
