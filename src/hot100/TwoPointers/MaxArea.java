package hot100.TwoPointers;

//LeetCode 11 盛水最多的容器
/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。
 */
public class MaxArea {
    public int getCapacity(int left, int right, int bottomLength) {
        return Math.min(left, right) * bottomLength;
    }

    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxCapacity = 0;
        while (head < tail) {
            maxCapacity = Math.max(maxCapacity, getCapacity(height[head], height[tail], tail - head));
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }

        return maxCapacity;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
