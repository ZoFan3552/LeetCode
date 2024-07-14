package everyday.mid;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int target) {
        //必须用到所有数
        //每个数可以变换正负
        //通过这种形式找到目标和
        /*
        目标是确定有多少种方法可以通过为数组 nums 的元素前添加 + 或 - 来达到 target。
        可以将其看作是分割数组为两个子集，一个子集的元素前有 +，另一个子集的元素前有 -，
        两个子集的差等于 target。
        设 P 为正子集的和，N 为负子集的和，则 P - N = target。
        同时，P + N = sum(nums)（数组所有元素的总和）。
        联立这两个方程，可以得到 P = (target + sum(nums)) / 2。问题转换为找到和为 P 的子集的数目。
         */
        int sumNums = 0;
        for (int num : nums) {
            sumNums += num;
        }

        // (sumNums + target) 必须是偶数才可能有解
        if ((sumNums + target) % 2 != 0 || sumNums < Math.abs(target)) {
            return 0;
        }

        int P = (sumNums + target) / 2;
        if (P < 0) {
            return 0; // 防止 P 是负数的情况
        }

        // dp[i] 表示和为 i 的子集的数目
        int[] dp = new int[P + 1];
        dp[0] = 1; // 和为0只有一种方法，什么都不取

        // 对每个数字进行处理，更新dp数组
        for (int num : nums) {
            for (int i = P; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[P];
    }

}
