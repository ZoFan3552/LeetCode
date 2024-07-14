package hot100.List;

import java.util.ArrayList;
import java.util.List;

public class RemoveFromNthEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode tempHead = head;
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }
        if (n == listNodes.size()){
            assert tempHead != null;
            tempHead = tempHead.next;
            return tempHead;
        }
        listNodes.get(listNodes.size() - n - 1).next = listNodes.get(listNodes.size() - n).next;
        return tempHead;
    }
}
