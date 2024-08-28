package everyday.easy;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/8 下午5:09
 */
public class FindTheIntegerAddedToArrayI_3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
