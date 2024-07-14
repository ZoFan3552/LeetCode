package hot100.Stack;

public class MinStack {
    /*
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    实现 MinStack 类:

    MinStack() 初始化堆栈对象。
    void push(int val) 将元素val推入堆栈。
    void pop() 删除堆栈顶部的元素。
    int top() 获取堆栈顶部的元素。
    int getMin() 获取堆栈中的最小元素。

     */
    static class ListNode {
        int val;
        int min;//每次在入栈时，都会和当前栈顶元素的最小值比较，这样保存的话在pop掉最小值时不会丢失下一个最小值
        ListNode next;
        ListNode(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    ListNode head;
    public MinStack() {
        //初始化一个空栈
    }

    public void push(int val) {
        if (head == null) {
            head = new ListNode(val, val);
        }else {
            ListNode node = new ListNode(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        }
        return 0;
    }

    public int getMin() {
        if (head != null) {
            return head.min;
        }
        return 0;
    }

}
