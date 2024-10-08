package hot100.BinaryTree;

import java.util.*;

public class MaxDepth {
    /*
    方法一：后序遍历（DFS）
    树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。

    关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度中的 最大值 +1 。
    算法解析：
    终止条件： 当 root为空，说明已越过叶节点，因此返回 深度 000 。
    递推工作： 本质上是对树做后序遍历。
    计算节点 root 的 左子树的深度 ，即调用 maxDepth(root.left)。
    计算节点 root 的 右子树的深度 ，即调用 maxDepth(root.right)。
    返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    BFS广度有限搜索
    树的层序遍历 / 广度优先搜索往往利用 队列 实现。

    关键点： 每遍历一层，则计数器 +1，直到遍历完成，则可得到树的深度。

    算法解析：
    特例处理： 当 root 为空，直接返回 深度 0 。
    初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
    循环遍历： 当 queue 为空时跳出。
    初始化一个空列表 tmp ，用于临时存储下一层节点。
    遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp。
    更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue。
    统计层数： 执行 res += 1 ，代表层数加 1。
    返回值： 返回 res 即可。

    class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.left.left = new TreeNode(4);
        int i = new MaxDepth().maxDepth(treeNode) - 1;
        System.out.println(i);

    }
}
