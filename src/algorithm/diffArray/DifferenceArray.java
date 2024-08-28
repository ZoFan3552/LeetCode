package algorithm.diffArray;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/5 上午10:22
 */
public class DifferenceArray {
    private final int[] diff;

    /**
     * 构造函数，初始化差分数组
     *
     * @param nums 原始数组
     */
    public DifferenceArray(int[] nums) {
        int n = nums.length;
        // 初始化差分数组
        diff = new int[n];
        // 第一个元素的差分值等于原始数组的第一个元素
        diff[0] = nums[0];
        // 计算差分数组
        for (int i = 1; i < n; i++) {
            // 差分数组的每个元素是原始数组当前元素与前一个元素的差
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 在区间 [l, r] 上增加 x
     *
     * @param l 左边界（包含）
     * @param r 右边界（包含）
     * @param x 增加的值
     */
    public void increment(int l, int r, int x) {
        // 在 l 位置增加 x
        diff[l] += x;
        // 如果 r+1 在数组范围内，在 r+1 位置减去 x
        //如果 r+1 位置在数组范围内，在 r+1 位置减去 x，表示从 r+1 开始的区间不再增加 x。
        if (r + 1 < diff.length) {
            diff[r + 1] -= x;
        }
    }

    /**
     * 获取结果数组
     *
     * @return 原始数组经过增量操作后的结果数组
     */
    public int[] result() {
        int n = diff.length;
        int[] res = new int[n];
        // 第一个元素等于差分数组的第一个元素
        res[0] = diff[0];
        // 通过累加差分数组恢复原始数组
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
