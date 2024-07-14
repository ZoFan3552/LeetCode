package hot100.Tricks;

import java.util.HashSet;

public class FindTheDuplicateNumber {
    /*
    这个问题的解法核心就在于把数组中的每个数值视作指向下一个索引的指针。由于题目条件确保了所有的数值都在1到n之间，而数组的大小为n+1，这就意味着至少有一个数是重复的。这样的设置使得数组形成了一个隐式的链表结构，其中至少一个节点（即一个数值）会被访问两次，形成了一个环。

    在这种情况下，由于没有任何数值会指向索引0（因为所有数值都至少为1），数组的第一个元素（位于索引0）可以作为“入口”来访问这个隐式链表。然后利用快慢指针法（Floyd's Tortoise and Hare Algorithm）来检测环，并确定环的起始位置，即重复的数字。

    这个方法的关键在于：

    数组的双重角色：数组既存储了数据，又通过数据的值隐式地定义了链表结构。每个元素指向下一个元素的索引。
    不越界的保证：由于所有的数都在1到n之间，它们自然成为数组索引的合法值，因此在索引访问时不会越界。
    环的检测：使用快慢指针检测链表中的环是一种标准技术，它在这里被用来找到重复的数。
     */
    public int findDuplicate(int[] nums) {
        //快慢指针法
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        }while (fast != slow);

        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
