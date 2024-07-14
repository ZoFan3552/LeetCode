package hot100.BinaryTree;

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        max = Math.max(max , leftDepth + rightDepth);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
