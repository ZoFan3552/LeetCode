package hot100.BinaryTree;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int highestLeft = helper(root.left);
        int highestRight = helper(root.right);
        int innerMaxSum = highestLeft + highestRight + root.val;//当前最大路径和为 左子树最大路径和 + 右子树最大路径和 + 当前结点值
        maxSum = Math.max(maxSum , innerMaxSum);
        int outputMaxSum = root.val + Math.max(highestLeft ,highestRight);//向上级提供的最大路径和，只能选左子树或右子树
        return Math.max(outputMaxSum ,0);
    }
}
