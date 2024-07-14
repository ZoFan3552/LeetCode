package hot100.MultiDimensionDP;

public class LongestCommonSubsequence {
    /*
    DP[i][j] 表示 长度为i的子串和长度为j的子串的最长公共序列
    DP[i][j] = DP[i - 1][j - 1] + 1 ，如果 text1[i] == text2[j] DP[i][j] = max（DP[i - 1][j]， DP[i][j - 1]）
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int res = new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace");
        System.out.println(res);
    }
}
