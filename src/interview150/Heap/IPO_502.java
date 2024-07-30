package interview150.Heap;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/17 下午12:18
 */
public class IPO_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 创建项目列表，并按照资本进行排序
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[] {capital[i], profits[i]});
        }
        projects.sort(Comparator.comparingInt(a -> a[0]));

        // 创建一个最大堆，用来存储可投资的项目的利润
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0; // 当前考虑的项目索引

        // 最多进行 k 次项目投资
        for (int j = 0; j < k; j++) {
            // 将所有当前资本 w 以下的项目利润加入到最大堆中
            while (i < n && projects.get(i)[0] <= w) {
                maxHeap.add(projects.get(i)[1]);
                i++;
            }

            // 如果最大堆非空，执行堆顶项目
            if (!maxHeap.isEmpty()) {
                w += maxHeap.poll();
            } else {
                // 没有可投资的项目，提前退出
                break;
            }
        }

        return w;
    }

    public static void main(String[] args) {
        IPO_502 ipo502 = new IPO_502();
        int res = ipo502.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        System.out.println(res);
    }
}
