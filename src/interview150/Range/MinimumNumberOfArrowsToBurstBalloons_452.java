package interview150.Range;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        //排序气球：按每个气球的结束坐标排序，从而确保我们总是先射击最先结束的气球。
        //使用贪心策略：从左至右遍历排序后的气球，每次发射的箭都会射向当前遍历到的气球的结束坐标。
        // 这样可以确保该箭能引爆当前气球，同时也尽可能多地引爆后续的气球。
        Arrays.sort(points , Comparator.comparingInt(a -> a[1]));
        int leastArrow = 1;
        int curArrow = points[0][1];
        for (int[] point : points) {
            if (!(curArrow >= point[0] && curArrow <= point[1])) {
                leastArrow++;
                curArrow = point[1];
            }
        }
        return leastArrow;
    }


    public static void main(String[] args) {
        int res = new MinimumNumberOfArrowsToBurstBalloons_452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        System.out.println(res);
    }
}
