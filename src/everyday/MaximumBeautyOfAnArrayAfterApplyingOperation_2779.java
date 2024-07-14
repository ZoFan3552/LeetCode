package everyday;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation_2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;
        int i = 0; // Step 2: 初始化 i

        for (int j = 0; j < nums.length; j++) { // Step 2: 逐步增加 j
            // Step 3: 调整 i 的位置直到子数组有效
            while (nums[j] - nums[i] > 2 * k) {
                i++;
            }
            // Step 4: 更新最大美丽值
            maxBeauty = Math.max(maxBeauty, j - i + 1);
        }

        return maxBeauty;
    }
}
