package interview150.LinkedList;

public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义一个虚拟节点，其next为head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        //因为题目的head位置是从1开始索引的，所以我们从dummy结点开始遍历，直到找到left位置的前一个节点
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        //反转链表的过程中，我们需要三个变量 pre——上一个节点 ， cur——当前节点 ，next——原来的上一个节点
        ListNode pre = null , cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            //每次循环，将当前节点的next指向上一个节点 ， cur节点成为下一次循环的pre节点 ， next成为下一个循环的cur节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

}
