package hot100.List;

import java.util.ArrayList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }
        return swap(listNodes);
    }

    public ListNode swap(ArrayList<ListNode> listNodes){
        int len  = listNodes.size() % 2 == 0 ? listNodes.size() : listNodes.size() - 1;
        for (int i = 0; i < len; i++) {
            ListNode temp = listNodes.get(i);
            listNodes.set(i, listNodes.get(i + 1));
            listNodes.set(i + 1 , temp);
            listNodes.get(i).next = null;
            listNodes.get(i + 1).next = null;
            i ++;
        }
        ListNode newNode = listNodes.get(0);
        ListNode resNode = newNode;
        for (int i = 1; i < listNodes.size(); i++) {
            newNode.next = listNodes.get(i);
            newNode = newNode.next;
        }
        return resNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        new SwapPairs().swapPairs(head);
    }

}
