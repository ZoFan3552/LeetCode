package everyday.hard;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/19 下午1:57
 */
public class StudentAttendanceRecordII_552 {
    public int checkRecord(int n) {
        //不能出现两个连续的 'A' 'A'
        //三种字符 'A' 'L' 'P'
        int MOD = 1000000007;
        // dp[i][j][k] 表示长度为 i，有 j 个 'A'，末尾有 k 个 'L' 的情况数量
        int[][][] dp = new int[n + 1][2][3];

        // 初始化状态
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // 末尾为 'P'
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;
                }
            }

            // 末尾为 'A'
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % MOD;
            }

            // 末尾为 'L'
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % MOD;
                }
            }
        }

        // 统计结果
        int result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }
        return result;
    }
}
