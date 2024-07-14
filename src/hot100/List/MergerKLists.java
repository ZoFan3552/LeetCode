package hot100.List;

import org.w3c.dom.html.HTMLTableColElement;

import java.util.ArrayList;
import java.util.Collections;

public class MergerKLists {
    //不要用递归
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        ListNode l1 = lists[0];
        for (int i = 0; i < lists.length - 1; i++) {
            l1 = mergeTwoLists(l1 , lists[i + 1]);
        }
        return l1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        } else{
            p.next = list1;
        }
        return dummyHead.next;
    }
}
