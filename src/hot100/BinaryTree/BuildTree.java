package hot100.BinaryTree;

import java.util.*;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            return null;
        }
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            temp.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, temp, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> temp, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = temp.get(rootVal);

        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, temp, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, temp, pIndex + 1, inRight);
        return root;
    }
}
