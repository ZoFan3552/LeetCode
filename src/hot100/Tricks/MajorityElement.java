package hot100.Tricks;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int vote = 0;
        for (int num : nums) {
            if (count == 0){
                vote = num;
            }
            count += (num == vote) ? 1 : -1;
        }
        return vote;
    }
}
