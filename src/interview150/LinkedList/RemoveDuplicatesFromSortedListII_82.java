package interview150.LinkedList;

public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode back = dummy;
        ListNode front = head;
        while (front != null){
            if (front.next == null ||  front.next.val != front.val){//没重复的就跳过
                back = front;
                front = front.next;
            }else {
                int dupVal = front.val;
                while (front != null && front.val == dupVal){
                    front = front.next;
                }
                back.next = front;
            }
        }
        return dummy.next;
    }
}
