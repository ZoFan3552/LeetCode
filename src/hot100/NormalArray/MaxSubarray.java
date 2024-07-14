package hot100.NormalArray;

public class MaxSubarray {
    /*
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    子数组是数组中的一个连续部分。本题是一道经典的动态规划题目
    1.将问题分解成若干个子问题
    2.根据子问题求出状态转移方程
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        //找初始值
        dp[0] = nums[0];//以nums[0]为结尾的子数组只有nums[0]本身，所以dp[0]为nums[0]
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {//如果上一个状态是一个大于0的数，我们认为可以加上当前数以继续遍历寻找最大和
                dp[i] = dp[i - 1] + nums[i];
            } else {//否则我们就重新以当前数为起始
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int maxSubArray = new MaxSubarray().maxSubArray(new int[]{8, -1, -9, 3, 8, 1, -4, 8, 6, -1, 8, 4, 2, 4, 7, -5});
        System.out.println(maxSubArray);
    }
}
