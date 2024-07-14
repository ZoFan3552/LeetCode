package interview150.Graph;

import java.util.*;

public class CloneGraph_133 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Map<Integer, Node> map = new HashMap<>();
        queue.add(node);
        map.put(node.val, new Node(node.val));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (Node neighbor : poll.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(poll.val).neighbors.add(map.get(neighbor.val));
            }
        }
        map.forEach((k, v) -> v.neighbors.forEach(n -> {
            System.out.println("new " + k + "->" + n.val);
        }));
        return map.get(1);
    }
}
