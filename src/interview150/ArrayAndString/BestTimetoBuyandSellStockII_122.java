package interview150.ArrayAndString;

public class BestTimetoBuyandSellStockII_122 {
    /*
    在使用动态规划解决这个问题时，我们可以定义状态来表示在每天结束时可能的最大利润。我们可以用两个状态变量来跟踪：

    dp[i][0]：在第 i 天结束时，我们手上没有股票的最大利润。
    dp[i][1]：在第 i 天结束时，我们手上持有一股股票的最大利润。
    对于每一天，我们有两种选择：

    如果我们在第 i 天结束时不持有股票，我们可能是在第 i 天卖掉了股票或者从前一天就没有股票。
    如果我们在第 i 天结束时持有股票，我们可能是在第 i 天买入了股票或者从前一天就持有了股票。
    这样，我们可以写出转移方程：

    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])：表示今天没有股票的最大利润，可以从昨天就没有股票继续今天，或者是昨天有股票今天卖掉了。
    dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])：表示今天持有股票的最大利润，可以从昨天就持有股票继续持有，或者是昨天没有股票今天买入了。
    初始化条件：

    dp[0][0] = 0：在第一天结束时，不持有股票，利润为 0。
    dp[0][1] = -prices[0]：在第一天结束时，买入股票，花费了 prices[0]。
    最后，我们想要的答案是 dp[n-1][0]，即最后一天结束时不持有股票的最大利润。
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int res = new BestTimetoBuyandSellStockII_122().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }
}
