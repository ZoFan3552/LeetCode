package everyday.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/23 上午11:06
 */
public class FindTheSumOfSubsequencePowers_3098 {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * 计算所有长度为 k 的子序列的力量之和
     *
     * @param nums 输入的整数数组
     * @param k 子序列的长度
     * @return 所有长度为 k 的子序列的力量之和
     */
    public int sumOfPowers(int[] nums, int k) {
        // 对数组进行排序
        Arrays.sort(nums);

        // 使用哈希映射 dp 进行记忆化
        Map<Long, Integer> memo = new HashMap<>();

        int result = 0;
        // 遍历数组，计算以每个元素结尾的长度为 k 的子序列的力量之和
        for (int i = nums.length - 1; i >= k - 1; i--) {
            result = (result + calculatePower(nums, k - 1, i, memo, Integer.MAX_VALUE)) % MOD;
        }
        return result;
    }

    /**
     * 递归计算以指定元素结尾的长度为 k 的子序列的力量
     *
     * @param nums 输入的整数数组
     * @param remainingLength 剩余需要计算的子序列长度
     * @param end 当前子序列的结尾索引
     * @param memo 记忆化哈希映射
     * @param minDifference 当前子序列的最小绝对差值
     * @return 以指定元素结尾的长度为 k 的子序列的力量
     */
    private int calculatePower(int[] nums, int remainingLength, int end, Map<Long, Integer> memo, int minDifference) {
        // 如果剩余长度小于等于 0，则返回当前最小差值
        if (remainingLength <= 0) {
            return minDifference;
        }

        // 生成哈希映射的键值
        long key = generateKey(minDifference, end, remainingLength);

        // 如果哈希映射中已存在该键值，则直接返回存储的值
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;
        // 遍历当前元素之前的所有元素，递归计算子序列的力量
        for (int i = end - 1; i >= remainingLength - 1; i--) {
            result = (result + calculatePower(nums, remainingLength - 1, i, memo, Math.min(minDifference, nums[end] - nums[i]))) % MOD;
        }

        // 将计算结果存储在哈希映射中
        memo.put(key, result);
        return result;
    }

    /**
     * 生成哈希映射的键值
     *
     * @param minDifference 当前子序列的最小绝对差值
     * @param end 当前子序列的结尾索引
     * @param remainingLength 剩余需要计算的子序列长度
     * @return 生成的键值
     */
    private long generateKey(int minDifference, int end, int remainingLength) {
        return ((long) minDifference << 32) + ((long) end << 16) + remainingLength;
    }
}
