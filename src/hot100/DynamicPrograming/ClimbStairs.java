package hot100.DynamicPrograming;

public class ClimbStairs {
    public int climbStairs(int n) {
        /*
             -  1 , n = 1
        An = -  2 , n = 2
             -  An-1 + An - 2 , n >= 3
        设dp[n]为到达n个台阶顶部的所有可能的跳法
        那么则我们需要知道跳 1 阶到n的和跳 2 阶到n的，所以可以得到递推公式 dp[n] = dp[n-1] + dp[n-2]
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;//特殊用例
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
