package everyday.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/12 上午9:22
 */
public class MinimumNumberGame_2974 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i+=2) {
            int alice = nums[i];
            int bob = nums[i+1];
            result[i] = bob;
            result[i+1] = alice;
        }
        return result;
    }
}
