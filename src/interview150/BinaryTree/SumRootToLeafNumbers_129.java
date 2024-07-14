package interview150.BinaryTree;

public class SumRootToLeafNumbers_129 {
    private static int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root , 0 );
        int res = sum;
        sum = 0;
        return res;
    }

    public void helper(TreeNode root , int curSum ) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            int temp = curSum * 10 + root.val;
            sum += temp;
        }
        helper(root.left, curSum * 10 + root.val);
        helper(root.right, curSum * 10 + root.val);
    }
}
