package hot100.NormalArray;

import java.util.*;

public class MergeIntervals {
    /*
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

    示例 1：

    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2：

    输入：intervals = [[1,4],[4,5]]
    输出：[[1,5]]
    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

    什么情况下要合并
    1.left[0] <= right[0]
    2.left[1] >= right[0]
    3.left[1] >= right[1]
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {//先排序才好方便进行判断
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        Deque<int[]> deque = new LinkedList<>();
        for (int[] interval : intervals) {
            if (deque.isEmpty()){
                deque.add(interval);
            }else {
                int[] left = deque.getLast();
                if (left[1] < interval[0] && left[1] < interval[1]){//不合并的条件
                    deque.add(interval);
                }else {
                    int rightMax = Math.max(interval[0],interval[1]);
                    deque.getLast()[1] = Math.max(rightMax , deque.getLast()[1]);
                }
            }
        }
        ArrayList<int[]> merges = new ArrayList<>(deque);

        return merges.toArray(new int[merges.size()][2]);
    }

    public static void main(String[] args) {
        int[][] merge = new MergeIntervals().merge(new int[][]{{1,4},{0,2},{3,5}});
        System.out.println(Arrays.deepToString(merge));
    }
}
