package hot100.List;

import java.util.ArrayList;
import java.util.HashMap;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> res = new ArrayList<>();
        int promotion = 0;//表示进位
        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int newVal = num1 + num2 + promotion;
            if (newVal >= 10){
                newVal -= 10;
                promotion = 1;
            }else {
                promotion = 0;
            }
            res.add(newVal);
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (promotion == 1){
            res.add(1);
        }
        ListNode node = new ListNode(res.get(0));
        ListNode head = node;
        for (int i = 1; i < res.size(); i++) {
            node.next = new ListNode(res.get(i));
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode head1 = l1;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode head2 = l2;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(head1, head2);
    }
}
