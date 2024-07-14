package everyday.hard;

import java.util.*;

public class MaximumPathQualityOfAGraph_2065 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] g = new ArrayList[n];//构建邻接表
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int t = e[2];
            g[x].add(new int[]{y, t});
            g[y].add(new int[]{x, t});
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;
        return dfs(0, 0, values[0], vis, g, values, maxTime);
    }

    private int dfs(int x, int sumTime, int sumValue, boolean[] vis, List<int[]>[] g, int[] values, int maxTime) {
        int res = x == 0 ? sumValue : 0;
        for (int[] e : g[x]) {
            int y = e[0];
            int t = e[1];
            if (sumTime + t > maxTime) {
                continue;
            }
            if (vis[y]) {
                res = Math.max(res, dfs(y, sumTime + t, sumValue, vis, g, values, maxTime));
            } else {
                vis[y] = true;
                // 每个节点的价值至多算入价值总和中一次
                res = Math.max(res, dfs(y, sumTime + t, sumValue + values[y], vis, g, values, maxTime));
                vis[y] = false; // 恢复现场
            }
        }
        return res;
    }
}
