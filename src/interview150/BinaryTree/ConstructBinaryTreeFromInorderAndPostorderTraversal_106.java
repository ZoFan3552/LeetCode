package interview150.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    static int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //左-根-右
        //左-右-根
        //把中序遍历数组的值存放到一个hash表中,方便后续寻找根节点
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        //从postorder中遍历根节点
        postIndex = postorder.length - 1;
        return build(postorder, 0, postorder.length - 1, inorderMap);
    }

    public TreeNode build(int[] postorder, int left, int right, Map<Integer, Integer> inorderMap) {
        if (left > right) return null;
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        int mid = inorderMap.get(val);
        root.right = build(postorder, mid + 1, right, inorderMap);//递归找右子树
        root.left = build(postorder, left, mid - 1, inorderMap);//递归找左子树
        return root;
    }

}
