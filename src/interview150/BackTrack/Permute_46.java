package interview150.BackTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/12 上午9:35
 */
public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums , visited, res, stack);
        return res;
    }

    private void backTrack(int[] nums , boolean[] visited , List<List<Integer>> res , ArrayDeque<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;//不能重复选
            visited[i] = true;
            stack.push(nums[i]);
            backTrack(nums , visited , res , stack);
            stack.pop();
            visited[i] = false;
        }
    }
}
