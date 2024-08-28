package everyday.mid;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/6 上午9:39
 */
public class FindAllPossibleStableBinaryArraysI_3129 {
    private static final int MOD = 1_000_000_007;

    // 计算稳定二进制数组的总数
    public int numberOfStableArrays(int zero, int one, int limit) {
        // 初始化 memo 数组，-1 表示没有计算过
        int[][][] memo = new int[zero + 1][one + 1][2];
        for (int[][] m : memo) {
            for (int[] m2 : m) {
                Arrays.fill(m2, -1); // 将所有值填充为 -1
            }
        }
        // 计算以 0 和 1 结尾的稳定数组总数，并取模
        return (dfs(zero, one, 0, limit, memo) + dfs(zero, one, 1, limit, memo)) % MOD;
    }

    // 深度优先搜索 + 记忆化搜索
    private int dfs(int i, int j, int k, int limit, int[][][] memo) {
        // 递归边界：没有 0 的情况
        if (i == 0) {
            return k == 1 && j <= limit ? 1 : 0;
        }
        // 递归边界：没有 1 的情况
        if (j == 0) {
            return k == 0 && i <= limit ? 1 : 0;
        }
        // 如果之前计算过，直接返回结果
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        // 计算以 0 结尾的情况
        if (k == 0) {
            memo[i][j][k] = (int) (((long) dfs(i - 1, j, 0, limit, memo) + dfs(i - 1, j, 1, limit, memo) +
                    (i > limit ? MOD - dfs(i - limit - 1, j, 1, limit, memo) : 0)) % MOD);
        } else { // 计算以 1 结尾的情况
            memo[i][j][k] = (int) (((long) dfs(i, j - 1, 0, limit, memo) + dfs(i, j - 1, 1, limit, memo) +
                    (j > limit ? MOD - dfs(i, j - limit - 1, 0, limit, memo) : 0)) % MOD);
        }
        return memo[i][j][k];
    }
}
