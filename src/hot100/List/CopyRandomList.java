package hot100.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null || head.next == null) return head;
        LinkedHashMap<Node , Integer> nodes = new LinkedHashMap<>();
        LinkedHashMap<Integer,Node> copiedNodes = new LinkedHashMap<>();
        int index = 0;
        while (head != null){
            nodes.put(head , index);
            copiedNodes.put(index,new Node(head.val));
            head = head.next;
            index++;
        }
        index = 0;
        for (Node node : nodes.keySet()) {
            Node copiedNode = copiedNodes.get(index);
            copiedNode.next = copiedNodes.getOrDefault(index + 1 , null);
            int randomIndex = node.random == null ? -1 : nodes.get(node.random);
            copiedNode.random = copiedNodes.getOrDefault(randomIndex , null);
            index++;
        }
        return copiedNodes.get(0);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node1;
        node2.random = node1;
        new CopyRandomList().copyRandomList(node1);
    }
}
