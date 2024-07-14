package interview150.BinaryTree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean toLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            if (toLeft){
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                toLeft = false;
                res.add(level);
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                toLeft = true;
                Collections.reverse(level);
                res.add(level);
            }

        }
        return res;
    }
}
