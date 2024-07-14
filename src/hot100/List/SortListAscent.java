package hot100.List;

import java.util.ArrayList;
import java.util.Collections;

public class SortListAscent {
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ArrayList<Integer> nodeVals = new ArrayList<>();
        ListNode tempHead = head;
        while (tempHead != null){
            nodeVals.add(tempHead.val);
            tempHead = tempHead.next;
        }
        Collections.sort(nodeVals);
        ListNode resHead = head;
        int index = 0;
        while (head != null){
            head.val = nodeVals.get(index);
            head = head.next;
            index++;
        }
        return resHead;
    }
}
