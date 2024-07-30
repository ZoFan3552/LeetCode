package interview150.Heap;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/17 下午1:28
 */
public class FindKPairsWithSmallestSums_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k); // 预分配空间
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        while (ans.size() < k) {
            int[] p = pq.poll();
            int i = p[1];
            int j = p[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j == 0 && i + 1 < nums1.length) {
                pq.add(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
            }
            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }
}
