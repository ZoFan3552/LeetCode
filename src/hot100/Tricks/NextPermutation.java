package hot100.Tricks;

import java.util.Arrays;
import java.util.Observer;
import java.util.function.BinaryOperator;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    /*
    从右向左寻找：找到第一个升序对 (i-1, i)，即满足 nums[i-1] < nums[i] 的最小 i。
    这是因为要使排列变大，我们需要增大尽可能靠右的数字。

    从右向左查找：如果找到了这样的 i-1，则从数组的末尾向左寻找第一个大于 nums[i-1] 的数，记为 nums[j]。

    交换：交换 nums[i-1] 和 nums[j]。

    反转：将位置 i 之后的所有元素反转（或者说排序），使得这部分变为升序，
    因为我们知道原来这部分是降序的，反转后就自动变成了升序。
         */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 从后向前找到第一个升序对
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            // 从后向前找到第一个大于 nums[i] 的元素
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        // 反转 i 之后的元素
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 3, 2});
    }
}
