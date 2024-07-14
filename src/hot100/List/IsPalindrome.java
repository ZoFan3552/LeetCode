package hot100.List;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        if (head.next == null){
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null){
            arrayList.add(head.val);
            head = head.next;
        }
        int left = 0 , right = arrayList.size() - 1;
        while (left < right){
            if ((int) arrayList.get(left) != arrayList.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode head = node;
        int[] arr = new int[]{1,2,2,1};
        for (int i : arr) {
            node.val = i;
            node.next = new ListNode();
            node = node.next;
        }
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }
}
