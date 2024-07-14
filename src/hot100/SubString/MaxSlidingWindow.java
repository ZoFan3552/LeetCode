package hot100.SubString;

import java.util.*;

public class MaxSlidingWindow {

    //双端序列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }
        //使用双端队列手动实现单调队列
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            //i为nums下标，需要在[i - k + 1, i]中选到最大值
            //则队列的头节点需要在[i - k + 1, i]的范围内，否则弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            //保证每次放进去的数字要比末尾的大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            //当i增长到符合第一个范围时。滑动的每一步都将队列的头节点放入结果数组
            if (i >= k - 1){
                res[index] = nums[deque.peek()];
                index++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] integers = new MaxSlidingWindow().maxSlidingWindow(new int[]{7,2,4}, 2);
        for (int integer : integers) {
            System.out.println(integer);
        }
    }
}
