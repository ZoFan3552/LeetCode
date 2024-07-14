package interview150.Range;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Step 1: 添加所有在 newInterval 之前结束的区间
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: 合并所有与 newInterval 重叠的区间
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // 更新新区间的起始点
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // 更新新区间的结束点
            i++;
        }
        // 添加合并后的 newInterval
        result.add(newInterval);

        // Step 3: 添加所有在 newInterval 之后开始的区间
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        int[][] res = new int[result.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j] = result.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new InsertInterval_57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }
}
