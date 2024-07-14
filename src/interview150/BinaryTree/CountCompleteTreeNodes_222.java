package interview150.BinaryTree;

public class CountCompleteTreeNodes_222 {
    private int count = 0;
    public int countNodes(TreeNode root) {
        helper(root);
        return count;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        count++;
        helper(root.left);
        helper(root.right);
    }
}
