package hot100.BinaryTree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
平衡二叉搜索树。
 */
public class BuildBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums , 0 , nums.length);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildBST().sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    }
}
