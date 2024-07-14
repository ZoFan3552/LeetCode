package hot100.NormalArray;

public class FirstMissingPositive {
    /*
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。


    示例 1：

    输入：nums = [1,2,0]
    输出：3
    解释：范围 [1,2] 中的数字都在数组中。
    示例 2：

    输入：nums = [3,4,-1,1]
    输出：2
    解释：1 在数组中，但 2 没有。
    示例 3：

    输入：nums = [7,8,9,11,12]
    输出：1
    解释：最小的正数 1 没有出现。
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int min = new FirstMissingPositive().firstMissingPositive(new int[]{1,-1,3,4});
        System.out.println(min);
    }
}
