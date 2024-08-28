package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/9 下午7:27
 */
public class FindTheIntegerAddedToArrayII_3132 {
    /*
    给你两个整数数组 nums1 和 nums2。

    从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。

    执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。

    返回能够实现数组相等的 最小 整数 x 。
     */

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int n = nums1.length;
        int min_x = Integer.MAX_VALUE;

        // 遍历所有可能的两个元素组合
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum_removed = nums1[i] + nums1[j];
                int x = (sum2 - (sum1 - sum_removed)) / (n - 2);
                min_x = Math.min(min_x, x);
            }
        }

        return min_x;
    }
}
