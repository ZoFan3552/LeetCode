package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/2 上午11:27
 */
public class RightTriangles_3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum, -1); // 提前减一
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                colSum[j] += row[j];
            }
        }

        long ans = 0;
        for (int[] row : grid) {
            int rowSum = -1; // 提前减一
            for (int x : row) {
                rowSum += x;
            }
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    ans += (long) rowSum * colSum[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long res = new RightTriangles_3128().numberOfRightTriangles(new int[][]{{1,0,0,0}, {0,1,0,1}, {1,0,0,0}});
        System.out.println(res);
    }
}
