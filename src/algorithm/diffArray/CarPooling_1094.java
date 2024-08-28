package algorithm.diffArray;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/5 上午10:34
 */
public class CarPooling_1094 {
    // 静态内部类，表示差分数组
    static class DifferenceArray {
        private final int[] diff;

        /**
         * 构造函数，初始化差分数组
         *
         * @param arr 原始数组
         */
        public DifferenceArray(int[] arr) {
            int n = arr.length;
            // 初始化差分数组
            diff = new int[n];
            // 第一个元素的差分值等于原始数组的第一个元素
            diff[0] = arr[0];
            // 计算差分数组
            for (int i = 1; i < n; i++) {
                // 差分数组的每个元素是原始数组当前元素与前一个元素的差
                diff[i] = arr[i] - arr[i - 1];
            }
        }

        /**
         * 在区间 [left, right) 上增加 x
         *
         * @param left  左边界（包含）
         * @param right 右边界（不包含）
         * @param x     增加的值
         */
        public void increment(int left, int right, int x) {
            // 在 left 位置增加 x
            diff[left] += x;
            // 如果 right 在数组范围内，在 right 位置减去 x
            if (right < diff.length) {
                diff[right] -= x;
            }
        }

        /**
         * 获取结果数组
         *
         * @return 原始数组经过增量操作后的结果数组
         */
        public int[] result() {
            int[] res = new int[diff.length];
            // 第一个元素等于差分数组的第一个元素
            res[0] = diff[0];
            // 通过累加差分数组恢复原始数组
            for (int i = 1; i < diff.length; i++) {
                res[i] = diff[i] + res[i - 1];
            }
            return res;
        }
    }

    /**
     * 判断是否可以完成所有乘车请求
     *
     * @param trips    乘车请求的数组，每个元素包含 [乘客数量, 上车站点, 下车站点]
     * @param capacity 车的容量
     * @return 如果可以完成所有乘车请求返回 true，否则返回 false
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int farthest = Integer.MIN_VALUE;
        // 找到最远的下车站点
        for (int[] trip : trips) {
            int dest = trip[2];
            farthest = Math.max(farthest, dest);
        }

        //初始化一个数组，其长度为最远的下车站点加1
        int[] arr = new int[farthest + 1];
        // 初始化差分数组
        DifferenceArray differenceArray = new DifferenceArray(arr);

        // 遍历所有乘车请求
        for (int[] trip : trips) {
            int x = trip[0];       // 乘客数量
            int left = trip[1];    // 上车站点
            int right = trip[2];   // 下车站点
            // 在区间 [left, right) 上增加 x 乘客
            differenceArray.increment(left, right, x);
        }

        // 获取乘车后的结果数组
        int[] result = differenceArray.result();

        // 遍历结果数组，判断是否有某个时刻的乘客数量超过车的容量
        for (int numPassenger : result) {
            if (numPassenger > capacity) {
                return false; // 如果超过车的容量，返回 false
            }
        }
        return true; // 如果所有时刻的乘客数量都没有超过车的容量，返回 true
    }
}
