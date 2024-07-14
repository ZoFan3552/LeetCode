package hot100.BinaryTree;

import java.util.ArrayList;

public class KthSmallest {
    ArrayList<Integer> temp = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return temp.get(temp.size() - 1);
    }

    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        if (temp.size() < k) {
            temp.add(root.val);
        }
        helper(root.right, k);
    }
}
