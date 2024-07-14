package everyday.hard;

import java.util.*;

public class MinimizeManhattanDistances_3102 {
    public static int minimumDistance(int[][] points) {
        final int INF = Integer.MAX_VALUE;
        int maxX1 = -INF, maxX2 = -INF, maxY1 = -INF, maxY2 = -INF;
        int minX1 = INF, minX2 = INF, minY1 = INF, minY2 = INF;
        int maxXi = 0, minXi = 0, maxYi = 0, minYi = 0;

        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int x = p[0] + p[1];
            int y = p[1] - p[0];

            // x 最大次大
            if (x > maxX1) {
                maxX2 = maxX1;
                maxX1 = x;
                maxXi = i;
            } else if (x > maxX2) {
                maxX2 = x;
            }

            // x 最小次小
            if (x < minX1) {
                minX2 = minX1;
                minX1 = x;
                minXi = i;
            } else if (x < minX2) {
                minX2 = x;
            }

            // y 最大次大
            if (y > maxY1) {
                maxY2 = maxY1;
                maxY1 = y;
                maxYi = i;
            } else if (y > maxY2) {
                maxY2 = y;
            }

            // y 最小次小
            if (y < minY1) {
                minY2 = minY1;
                minY1 = y;
                minYi = i;
            } else if (y < minY2) {
                minY2 = y;
            }
        }

        int ans = INF;
        for (int i : new int[]{maxXi, minXi, maxYi, minYi}) {
            int dx = (i == maxXi ? maxX2 : maxX1) - (i == minXi ? minX2 : minX1);
            int dy = (i == maxYi ? maxY2 : maxY1) - (i == minYi ? minY2 : minY1);
            ans = Math.min(ans, Math.max(dx, dy));
        }
        return ans;

    }

    public static void main(String[] args) {
        int res = minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}});
        System.out.println(res);
    }
}
