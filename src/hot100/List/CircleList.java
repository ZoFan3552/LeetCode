package hot100.List;

import java.util.HashMap;
import java.util.HashSet;

public class CircleList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null){
            if (nodes.contains(head)){
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
}
