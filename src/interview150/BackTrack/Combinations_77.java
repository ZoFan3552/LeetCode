package interview150.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/11 上午11:30
 */
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        // 开始回溯过程，从数字1开始
        backtrack(combinations, new ArrayList<>(), 1, n, k);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> currentCombination, int start, int n, int k) {
        // 当当前组合长度等于k时，添加到结果列表
        if (currentCombination.size() == k) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // 递归添加下一个元素
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(combinations, currentCombination, i + 1, n, k);
            currentCombination.remove(currentCombination.size() - 1); // 回溯，移除最后一个元素
        }
    }
}
