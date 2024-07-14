package interview150.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST_530 {
    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            min = Math.min(min, res.get(i + 1) - res.get(i));
        }
        return min;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}
