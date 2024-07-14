package interview150.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII_117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        helper(queue);
        return root;
    }

    public void helper(Queue<Node> queue) {
        if (queue.isEmpty()) return;
        Queue<Node> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null){
                if (queue.isEmpty()){
                    node.next = null;
                }else {
                    while (!queue.isEmpty() && queue.peek() == null){
                        queue.poll();
                    }
                    node.next = queue.peek();
                }
                newQueue.offer(node.left);
                newQueue.offer(node.right);
            }
        }
        helper(newQueue);
    }
}
