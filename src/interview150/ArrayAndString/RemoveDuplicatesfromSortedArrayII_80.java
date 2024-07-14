package interview150.ArrayAndString;

public class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 2 , fast = 2;
        while (fast < n){
            // 如果 nums[fast] 不等于 nums[slow - k]
            // 则将 nums[fast] 复制到 nums[slow]，并将 slow 向前移动一位
            if (nums[fast] != nums[slow - 2]) { //nums[slow - k] 是当前考虑的元素在新数组中的第一个可能的位置
                nums[slow] = nums[fast];
                slow++;
            }
            // 将 fast 向前移动一位，以检查下一个元素
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int res = new RemoveDuplicatesfromSortedArrayII_80().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(res);
    }
}
