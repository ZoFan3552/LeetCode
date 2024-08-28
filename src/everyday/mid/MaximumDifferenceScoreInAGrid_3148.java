package everyday.mid;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/15 上午10:58
 */
public class MaximumDifferenceScoreInAGrid_3148 {
    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            dp[i + 1][0] = Integer.MAX_VALUE;
            List<Integer> row = grid.get(i);
            for (int j = 0; j < n; j++) {
                int mn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                int x = row.get(j);
                ans = Math.max(ans, x - mn);
                dp[i + 1][j + 1] = Math.min(mn, x);
            }
        }
        return ans;
    }

}
