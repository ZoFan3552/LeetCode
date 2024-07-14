package interview150.LinkedList;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = head;
        int listLen = 0;
        while (tail != null){
            tail = tail.next;
            listLen++;
        }
        if (k >= listLen){
            k = k % listLen;
        }
        if (k == 0) return dummy.next;
        ListNode newHead = head;
        for (int i = 0; i < listLen - k; i++) {
            if (i == listLen - k - 1){
                ListNode temp = newHead;
                newHead = newHead.next;
                temp.next = null;
            }else {
                newHead = newHead.next;
            }
        }
        ListNode newDummy = new ListNode();
        newDummy.next = newHead;
        while (newHead.next != null){
            newHead = newHead.next;
        }
        newHead.next = dummy.next;
        return newDummy.next;
    }

    public static void main(String[] args) {
        RotateList_61 rotateList61 = new RotateList_61();
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 1; i <= 5 ; i++) {
            if (i == 5){
                temp.val = i;
            }else {
                temp.val = i;
                temp.next = new ListNode();
                temp = temp.next;
            }

        }
        rotateList61.rotateRight(head , 2);
    }
}
