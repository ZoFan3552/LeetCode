package interview150.BinaryTree;

public class BinaryTreeMaximumPathSum_124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    // 以本节点curr为路径的起始节点，寻找最长路径
    private int maxSum(TreeNode curr) {
        if (curr == null) { // 如果当前节点为null
            return 0; // 则最长路径为0
        }
        int leftMax = maxSum(curr.left); // 在左子树中寻找 以左子节点为路径的起始节点的 最长路径
        int rightMax = maxSum(curr.right); // 在右子树中寻找 以右子节点为路径的起始节点的 最长路径
        int currMax = Math.max(Math.max(leftMax, rightMax), 0) + curr.val; // 以当前节点为路径的起始节点的 最长路径
        int allMax = Math.max(curr.val + leftMax + rightMax, currMax); // 以当前节点为路径的起始节点 或 以当前节点为中转节点的 最长路径
        max = Math.max(allMax, max); // 更新最长路径
        return currMax; // 返回 以当前节点为路径的起始节点的 最长路径
    }

}
