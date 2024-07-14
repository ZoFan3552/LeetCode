package hot100.BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subnets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTracking(track,nums,0);
        return res;
    }


    public void backTracking(LinkedList<Integer> track, int[] nums, int startIndex ) {
        res.add(new ArrayList<>(track));//决策数里面的每一个结点都是我们需要的结果
        for (int i = startIndex; i < nums.length; i++) {//为了避免重复取到前面已经判断过的元素，需要设置一个startIndex，这样每次递归取的都是后面的元素
            track.add(nums[i]);
            backTracking(track, nums,  i + 1);//下一次循环取后面的
            track.removeLast();//回溯，状态重置
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subnets().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
