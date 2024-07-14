package everyday.hard;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/11 上午10:15
 */
public class CountTheNumberOfIncremovableSubarraysII_2972 {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) { // 每个非空子数组都可以移除
            return (long) n * (n + 1) / 2;
        }

        long ans = i + 2; // 不保留后缀的情况，一共 i+2 个
        // 枚举保留的后缀为 nums[j:]
        for (int j = n - 1; j == n - 1 || nums[j] < nums[j + 1]; j--) {
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
            }
            // 可以保留前缀 nums[:i+1], nums[:i], ..., nums[:0] 一共 i+2 个
            ans += i + 2;
        }
        return ans;
    }
}
