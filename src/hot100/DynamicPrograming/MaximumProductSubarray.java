package hot100.DynamicPrograming;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //使用二维DP，dp[n][0]表示以nums[n]为结尾的最大连续乘积，dp[n][1]表示以nums[n]为结尾的最小连续乘积
        //根据nums[n]是正数还是负数去判断
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            }else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int[] num : dp) {
            res = Math.max(res, num[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new MaximumProductSubarray().maxProduct(new int[]{2, -5, -2, -4, 3});
        System.out.println(res);
    }
}
