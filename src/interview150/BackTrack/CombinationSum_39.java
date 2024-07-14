package interview150.BackTrack;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/12 上午9:48
 */
public class CombinationSum_39 {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        backTrack(candidates, stack, target, 0, 0);
        return res;
    }

    public void backTrack(int[] candidates , ArrayDeque<Integer> stack, int target , int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            stack.push(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, stack, target, sum, i);
            sum -= candidates[i];
            stack.pop();
        }
    }
}
