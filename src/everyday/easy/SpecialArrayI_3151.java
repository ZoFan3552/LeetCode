package everyday.easy;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/13 上午11:02
 */
public class SpecialArrayI_3151 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        int p1 = 0 , p2 = 1;
        while (p2 < nums.length){
            if((nums[p1] & 1) == 1 && (nums[p2] & 1) == 1) return false;
            if((nums[p1] & 1) == 0 && (nums[p2] & 1) == 0) return false;
            p1++;
            p2++;
        }
        return true;
    }
}
