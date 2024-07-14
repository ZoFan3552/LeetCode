package interview150.BinaryTree;

public class PathSum_112 {
    boolean found = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        helper(root , targetSum , 0 );
        return found;
    }

    public void helper(TreeNode root, int targetSum , int curSum) {
        if (root == null) return;
        if (found) return;
        if ((root.left == null && root.right == null) && curSum + root.val == targetSum) {
            found = true;
            return;
        }
        helper(root.left, targetSum, curSum + root.val);
        helper(root.right, targetSum, curSum + root.val);
    }
}
