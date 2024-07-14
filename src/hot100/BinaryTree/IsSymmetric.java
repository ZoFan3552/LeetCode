package hot100.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    /*
        递归实现
    乍一看无从下手，但用递归其实很好解决。
    根据题目的描述，镜像对称，就是左右两边相等，也就是左子树和右子树是相当的。
    注意这句话，左子树和右子相等，也就是说要递归的比较左子树和右子树。
    我们将根节点的左子树记做 left，右子树记做 right。比较 left 是否等于 right，不等的话直接返回就可以了。
    如果相当，比较 left 的左节点和 right 的右节点，再比较 left 的右节点和 right 的左节点
    比如看下面这两个子树(他们分别是根节点的左子树和右子树)，能观察到这么一个规律：
    左子树 2 的左孩子 == 右子树 2 的右孩子
    左子树 2 的右孩子 == 右子树 2 的左孩子

        2         2
       / \       / \
      3   4     4   3
     / \ / \   / \ / \
    8  7 6  5 5  6 7  8
    根据上面信息可以总结出递归函数的两个条件：
    终止条件：

    left 和 right 不等，或者 left 和 right 都为空
    递归的比较 left，left 和 right.right，递归比较 left，right 和 right.left
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DFS(root.left, root.right);
    }

    public boolean DFS(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return DFS(left.left, right.right) && DFS(left.right, right.left);
    }

}
