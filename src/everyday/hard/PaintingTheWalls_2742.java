package everyday.hard;

import java.util.Arrays;

public class PaintingTheWalls_2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 防止加法溢出
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i];
            int t = time[i] + 1; // 注意这里加一了
            for (int j = n; j > 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
            }
        }
        return f[n];
    }
}
