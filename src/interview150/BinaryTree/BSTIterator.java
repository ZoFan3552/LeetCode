package interview150.BinaryTree;

import java.util.*;

public class BSTIterator {
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        buildList(root);
        queue.addFirst(new TreeNode(Integer.MIN_VALUE));
    }

    public int next() {
        queue.removeFirst();
        assert queue.peek() != null;
        return queue.getFirst().val;
    }

    public boolean hasNext() {
        return queue.size() > 1;
    }


    public void buildList(TreeNode root) {
        if (root == null) return;
        buildList(root.left);
        queue.offer(root);
        buildList(root.right);
    }
}
