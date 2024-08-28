package everyday.mid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/31 下午12:46
 */
public class MinimumRectanglesToCoverPoints_3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        //从左往右扫描
        int[] XPoints = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            XPoints[i] = points[i][0];
        }
        Arrays.sort(XPoints);//根据横坐标排序
        int rectangleNum = 0;
        int index = 0;
        int baseX = XPoints[0];
        while (index < XPoints.length) {
            if (XPoints[index] - baseX > w) {
                rectangleNum++;
                baseX = XPoints[index];
            }
            index++;
        }
        rectangleNum++;
        return rectangleNum;
    }


}
