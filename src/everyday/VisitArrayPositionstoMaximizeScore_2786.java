package everyday;

public class VisitArrayPositionstoMaximizeScore_2786 {
    /*
    给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。

    你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：

    如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
    对于你访问的位置 i ，你可以获得分数 nums[i] 。
    如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
    请你返回你能得到的 最大 得分之和。

    注意 ，你一开始的分数为 nums[0] 。
     */
    public long maxScore(int[] nums, int x) {
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        long maxOdd = (nums[0] % 2 != 0) ? nums[0] : Integer.MIN_VALUE;
        long maxEven = (nums[0] % 2 == 0) ? nums[0] : Integer.MIN_VALUE;
        long maxScore = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            if (nums[i] % 2 == 0) { // nums[i] is even
                dp[i] = nums[i] + Math.max((maxOdd != Integer.MIN_VALUE) ? maxOdd - x : Integer.MIN_VALUE, maxEven);
                maxEven = Math.max(maxEven, dp[i]);
            } else { // nums[i] is odd
                dp[i] = nums[i] + Math.max((maxEven != Integer.MIN_VALUE) ? maxEven - x : Integer.MIN_VALUE, maxOdd);
                maxOdd = Math.max(maxOdd, dp[i]);
            }
            maxScore = Math.max(maxScore , dp[i]);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        long l = new VisitArrayPositionstoMaximizeScore_2786().maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5);
        System.out.println(l);
    }
}
