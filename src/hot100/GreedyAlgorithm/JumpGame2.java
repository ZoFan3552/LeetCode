package hot100.GreedyAlgorithm;

public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        /*
        定义 f[i] 为到达第 i 个位置所需要的最少步数，那么答案是 f[n−1]
        最后一个点前面可能会有很多个点能够一步到达最后一个点
        也即 f[n -1] = min{f[n - k] , ... , f[n - 3] , f[n - 2]} + 1
        且 f[n - k] <= ... <= f[n - 3] <= f[n - 2] 即任意区间都存在能一步到达该位置的点
        则每次取 f[i] = f[j] + 1
         */
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1 ,  j = 0; i < n; i++) {
            while (j + nums[j] < i){
                j++;
            }
            dp[i] = dp[j] + 1;
        }
        return dp[n - 1];
    }
}
