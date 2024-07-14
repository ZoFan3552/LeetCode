package hot100.List;

class GetInterSectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针做法
        //两个指针一旦到了末尾就重新指向对方链表的头节点
        //若是相交链表，指针终会相遇
        //若是不相交链表，指针最后都指向null
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}


