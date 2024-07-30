package interview150.DynamicPrograming;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/23 上午11:35
 */
public class Triangle_120 {
    /**
     * 找出自顶向下的最小路径和
     *
     * @param triangle 输入的三角形，按层级存储在列表中
     * @return 最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 初始化二维 dp 数组
        int[][] dp = new int[n][n];

        // 初始化最底层的 dp 值，直接等于三角形的最底层
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // 自底向上计算每层的 dp 值
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 当前元素的最小路径和等于当前元素值加上下一行相邻两个元素中较小的那个
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        // dp[0][0] 现在包含了从顶到底的最小路径和
        return dp[0][0];
    }
}
