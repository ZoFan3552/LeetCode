package interview150.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            ArrayDeque<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    temp.offer(poll.left);
                }
                if (poll.right != null) {
                    temp.offer(poll.right);
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp.getLast().val);
            }
            queue = temp;
        }
        return res;
    }
}
