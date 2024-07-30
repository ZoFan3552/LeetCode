package interview150.Math;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/21 下午1:19
 */
public class MaxPointsOnALine_149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;  // 如果点数少于等于2，直接返回点的数量
        int result = 0;

        // 遍历每个点i
        for (int i = 0; i < n; i++) {
            //如果当前结果已经大于或等于剩余的点数，则无需继续检查，因为无法找到更多的点在同一直线上。
            //如果当前结果已经大于点数的一半，则无需继续检查，因为最多的点数在同一直线上不会超过当前结果。
            if (result >= n - i || result > n / 2) break;  // 提前终止条件
            // 遍历点i之后的每个点j
            for (int j = i + 1; j < n; j++) {
                int count = 2;  // 初始化计数，包含点i和点j
                // 遍历点j之后的每个点k
                for (int k = j + 1; k < n; k++) {
                    // 判断三点是否在同一直线上
                    //使用交叉相乘的方法计算斜率，避免浮点数除法带来的精度问题。
                    int s1 = (points[j][1] - points[i][1]) * (points[k][0] - points[j][0]);
                    int s2 = (points[j][0] - points[i][0]) * (points[k][1] - points[j][1]);
                    if (s1 == s2) count++;
                }
                // 更新最大值
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
