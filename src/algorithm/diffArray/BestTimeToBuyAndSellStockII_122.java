package algorithm.diffArray;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/5 上午10:56
 */
public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 边界情况：如果价格数组长度小于2，无法进行买卖，利润为0
        if (n < 2) {
            return 0;
        }

        // 差分数组，用于存储每日价格变化量
        int[] diff = new int[n - 1];
        // 计算差分数组
        for (int i = 1; i < n; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }

        int maxProfit = 0;
        // 遍历差分数组，累加所有正的变化量
        for (int change : diff) {
            if (change > 0) {
                maxProfit += change;
            }
        }

        return maxProfit;
    }
}
