package everyday.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/21 上午10:30
 */
public class MaximumSubarraySumWithOneDeletion_1186 {
    public int maximumSum(int[] arr) {
        //删除负数
        int n = arr.length;
        if (n == 1) return arr[0];

        /*
        对于 nonDeletedMaxSum[i]，我们可以选择将 arr[i] 加入之前的子数组，或者从 arr[i] 重新开始一个新的子数组：
         */
        int[] nonDeletedMaxSum = new int[n];
        /*
        对于 dp2[i]，我们有两种情况：
        1.删除当前元素 arr[i]，所以状态转移为 deletedMaxSum[i-1]。
        2.不删除当前元素，而是删除之前的某个元素，所以状态转移为 deletedMaxSum[i-1] + arr[i]：
         */
        int[] deletedMaxSum = new int[n];

        nonDeletedMaxSum[0] = arr[0];
        deletedMaxSum[0] = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < n; i++) {
            nonDeletedMaxSum[i] = Math.max(nonDeletedMaxSum[i - 1] + arr[i], arr[i]);
            deletedMaxSum[i] = Math.max(nonDeletedMaxSum[i - 1] ,deletedMaxSum[i - 1] +  arr[i]);
            maxSum = Math.max(maxSum , Math.max(nonDeletedMaxSum[i], deletedMaxSum[i]));
        }
        return maxSum;
    }
}
