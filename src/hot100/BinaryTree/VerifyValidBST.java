package hot100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class VerifyValidBST {
    /*
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

    有效 二叉搜索树定义如下：

    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。

     */
    Integer lastVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (lastVal != null && root.val <= lastVal){
            return false;
        }
        lastVal = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
