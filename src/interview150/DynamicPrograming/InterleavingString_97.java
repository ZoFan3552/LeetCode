package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/25 下午12:47
 */
public class InterleavingString_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();

        if (m + n != l) {
            return false;
        }
        //交错——若干个连续子串分别交叉连接
        /*
        初始化：

        dp[0][0] 应为 true，因为空字符串可以由两个空字符串交错组成。
        dp[i][0] 取决于 s1 的前 i 个字符能否构成 s3 的前 i 个字符。
        dp[0][j] 取决于 s2 的前 j 个字符能否构成 s3 的前 j 个字符。
        状态转移：

        对于每个 dp[i][j]，有两种情况：
        如果 s1 的第 i 个字符等于 s3 的第 i+j 个字符，并且 dp[i-1][j] 为 true，则 dp[i][j] 为 true。
        如果 s2 的第 j 个字符等于 s3 的第 i+j 个字符，并且 dp[i][j-1] 为 true，则 dp[i][j] 为 true。
        结果：

        最终结果是 dp[s1.length()][s2.length()]。
         */
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args) {
        boolean res = new InterleavingString_97().isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }
}
