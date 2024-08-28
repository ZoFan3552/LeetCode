package everyday.mid;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/11 下午4:37
 */
public class UncrossedLines_1035 {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        //动态规划
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]表示长度 i 的 A序列和长度为 j 的 B 序列有多少条不相交的线
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int res = maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});
        System.out.println(res);
    }
}
