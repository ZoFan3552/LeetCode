package everyday.mid;

public class CountAlternatingSubarrays_3101 {
    public static long countAlternatingSubarrays(int[] nums) {
        if (nums.length <= 1) return nums.length;
        //长度为1的子数组也是交替子数组
        long count = 0;
        //动态规划
        //设 dp[i] 是以 index i 结尾的交替子数组的数量。
        int[] dp = new int[nums.length];
        dp[0] = 1;
        count += dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = 1;
            }else {
                dp[i] = dp[i - 1] + 1;
            }
            count += dp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        long res = countAlternatingSubarrays(new int[]{0,1,1,1});
        System.out.println(res);
    }
}
