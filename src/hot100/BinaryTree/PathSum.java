package hot100.BinaryTree;

import javax.management.MBeanAttributeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathSum {

    /*
    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。


     */
    int res = 0;
    //利用前缀和的形式
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();//key为sum value为满足此前缀和的路径数
        prefix.put(0L, 1);//初始放入0这个前缀和 默认有一条路径满足
        DFS(root, prefix, 0L, targetSum);
        return res;
    }

    public void DFS(TreeNode root, Map<Long, Integer> prefix, long currentSum, int targetSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;

        res += prefix.getOrDefault(currentSum - targetSum, 0);
        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) + 1);//每次将路径和放入前缀和map
        DFS(root.left, prefix, currentSum, targetSum);//递归继续查找
        DFS(root.right, prefix, currentSum, targetSum);
        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) - 1);//每次退出时要将map中的前缀和满足的路径数 - 1
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
