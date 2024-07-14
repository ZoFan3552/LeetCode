package hot100.BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backTracking(track, nums, visited);
        return res;
    }

    public void backTracking(LinkedList<Integer> track, int[] nums , boolean[] visited) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backTracking(track, nums, visited);
            track.removeLast();
            visited[i] = false;
        }
    }
}
