package everyday.hard;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/28 上午11:47
 */
public class FallingSquares_699 {
    // 定义线段树节点
    static class Node {
        private final int leftX; // 当前节点表示的区间的左边界
        private final int rightX; // 当前节点表示的区间的右边界
        private final int maxHeight; // 当前节点的最大高度
        private int maxR; // 当前节点的右边界范围内的最大右边界
        Node leftChild, rightChild; // 左子树和右子树

        public Node(int leftX, int rightX, int height, int maxR) {
            this.leftX = leftX;
            this.rightX = rightX;
            this.maxHeight = height;
            this.maxR = maxR;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    // 主函数，返回每次方块掉落后的最高高度
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>(); // 创建返回值列表
        Node root = null; // 初始化根节点为空
        int curMax = 0; // 当前的最大高度

        for (int[] position : positions) {
            int left = position[0]; // 获取方块的左坐标
            int right = position[0] + position[1]; // 计算方块的右坐标
            int edge = position[1]; // 获取方块的边长
            int curMaxHigh = query(root, left, right); // 查询当前区间的最大高度
            root = update(root, left, right, curMaxHigh + edge); // 更新线段树
            curMax = Math.max(curMax, curMaxHigh + edge); // 更新当前最大高度
            res.add(curMax); // 将当前最大高度添加到结果列表中
        }
        return res;
    }

    /**
     * 更新线段树，给定区间更新最大高度
     *
     * @param root   根节点
     * @param left   左边界
     * @param right  右边界
     * @param height 新的高度
     * @return 更新后的根节点
     */
    private Node update(Node root, int left, int right, int height) {
        if (root == null) {
            return new Node(left, right, height, right); // 如果根节点为空，创建新节点
        }
        if (left <= root.leftX) {
            root.leftChild = update(root.leftChild, left, right, height); // 更新左子树
        } else {
            root.rightChild = update(root.rightChild, left, right, height); // 更新右子树
        }
        root.maxR = Math.max(right, root.maxR); // 更新当前节点的最大右边界
        return root;
    }

    /**
     * 查询给定区间的最大高度
     *
     * @param root  根节点
     * @param left  左边界
     * @param right 右边界
     * @return 区间内的最大高度
     */
    private int query(Node root, int left, int right) {
        if (root == null || left >= root.maxR) {
            return 0; // 如果根节点为空或查询区间在当前节点的右边界之外，返回0
        }
        int curHeight = 0;
        if (right > root.leftX && left < root.rightX) {
            curHeight = root.maxHeight; // 如果查询区间与当前节点区间有交集，获取当前节点的最大高度
        }
        curHeight = Math.max(curHeight, query(root.leftChild, left, right)); // 查询左子树
        if (right > root.leftX) {
            curHeight = Math.max(curHeight, query(root.rightChild, left, right)); // 查询右子树
        }
        return curHeight;
    }
}
