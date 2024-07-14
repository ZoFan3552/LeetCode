package hot100.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeTwoLists {
    /*
    递归解法
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //合并两个升序链表
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode tail1 = list1;
        ListNode head1 = list1;
        while (tail1.next != null){
            arrayList.add(tail1.val);
            tail1 = tail1.next;
        }
        arrayList.add(tail1.val);
        tail1.next = list2;
        while (list2 != null){
            arrayList.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(arrayList);
        for (Integer i : arrayList) {
            list1.val = i;
            list1 = list1.next;
        }
        return head1;
    }
}
