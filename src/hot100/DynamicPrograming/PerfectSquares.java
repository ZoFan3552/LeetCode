package hot100.DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {//遍历背包
            for (int j = 1; j * j <= i; j++) {//遍历物品
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int numSquares = new PerfectSquares().numSquares(19);
        System.out.println(numSquares);
    }
}
