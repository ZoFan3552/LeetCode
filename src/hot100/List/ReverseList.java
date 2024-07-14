package hot100.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode last = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = last;
            last = current;
            current = temp;
        }
        return last;
    }
}



