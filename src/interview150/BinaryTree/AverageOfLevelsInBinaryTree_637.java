package interview150.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
