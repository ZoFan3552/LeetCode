package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/15 下午1:13
 */
public class MaximumSumCircularSubarray_918 {
    // 计算非环形数组中的最大子数组和
    private int kadaneMax(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }

    // 计算非环形数组中的最小子数组和
    private int kadaneMin(int[] nums) {
        int minCurrent = nums[0];
        int minGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minCurrent = Math.min(nums[i], minCurrent + nums[i]);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        return minGlobal;
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 非环形最大子数组和
        int maxNormal = kadaneMax(nums);

        // 数组总和
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 非环形最小子数组和
        int minSubarraySum = kadaneMin(nums);
        int maxCircular = totalSum - minSubarraySum;

        // 如果所有元素都是负数，最小子数组和会等于总和
        if (minSubarraySum == totalSum) {
            return maxNormal;
        }

        // 返回非环形和环形情况中的较大值
        return Math.max(maxNormal, maxCircular);
    }
}
