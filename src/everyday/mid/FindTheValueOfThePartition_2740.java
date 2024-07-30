package everyday.mid;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/26 下午12:06
 */
public class FindTheValueOfThePartition_2740 {
    public int findValueOfPartition(int[] nums) {
        //max(nums1) - min(nums2) 最小
        Arrays.sort(nums);
        int minSub = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            minSub = Math.min(minSub , Math.abs(nums[i + 1] - nums[i]));
        }
        return minSub;
    }
}
