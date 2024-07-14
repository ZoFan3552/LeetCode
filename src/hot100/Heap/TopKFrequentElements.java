package hot100.Heap;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> frequency = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            frequency.add(entry);
            if (frequency.size() > k) {
                frequency.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = Objects.requireNonNull(frequency.poll()).getKey();
        }
        return res;
    }
}
