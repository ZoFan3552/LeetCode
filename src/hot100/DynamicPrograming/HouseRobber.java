package hot100.DynamicPrograming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        /*
        设 dp[n] 为 n + 1 个房屋所能打劫得到的最大金额，若要得到这个金额，我们需要知道 max{nums[n] + dp[n-2] , dp[n-1]}
        为什么 dp[n-1] 不能加上nums[n]?这是因为题目所限制的不能抢劫相邻的房子，所以若是前面所能得到的最大值dp[n-1]时，
        自然dp[n] = dp[n-1]，因为你不能抢劫第 n 间房子，它和第 n-1 间房子相邻
        在房屋数量为 3 座以上时可进行递推
         */
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
