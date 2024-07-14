package interview150.LinkedList;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallDummy = small, bigDummy = big;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = new ListNode(cur.val);
                small = small.next;
            }else {
                big.next = new ListNode(cur.val);
                big = big.next;
            }
            cur = cur.next;
        }
        small.next = bigDummy.next;
        return smallDummy.next;
    }

}
