package interview150.BinarySearch;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/16 上午11:36
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        // 初始化左右指针
        int left = 0, right = nums.length - 1;

        // 当左指针小于右指针时，继续循环
        // 这意味着在左指针和右指针相遇之前，我们一直寻找峰值
        while (left < right) {
            // 计算中点索引，这是防止加法溢出的标准方式
            int mid = left + ((right - left) >> 1);

            // 检查中间元素与其右侧元素的关系
            if (nums[mid] < nums[mid + 1]) {
                // 如果中间元素小于其右侧元素，
                // 则峰值必定在中间元素的右侧（包括 mid + 1）
                // 因为数组两端被认为是负无穷
                left = mid + 1;
            } else {
                // 否则，峰值在左侧，或者 mid 就是峰值
                right = mid;
            }
        }
        // 循环结束时，left 和 right 相等，都指向峰值元素
        return left;  // 返回 left 或 right 都可以，因为它们相等
    }
}
