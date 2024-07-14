package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/13 下午6:02
 */
public class FindIfArrayCanBeSorted_3011 {
    public boolean canSortArray(int[] nums) {
        int p = 0;
        List<int[]> temp = new ArrayList<>();
        while (p < nums.length) {
            int min = nums[p];
            int max = nums[p];
            while (p + 1 < nums.length && hasSameOneBits(nums[p], nums[p + 1])) {
                min = Math.min(min, nums[p]);
                min = Math.min(min, nums[p + 1]);
                max = Math.max(max, nums[p]);
                max = Math.max(max, nums[p + 1]);
                p++;
            }
            temp.add(new int[]{min, max});
            p++;
        }
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i)[1] >= temp.get(i + 1)[0]) {
                return false;
            }
        }
        return true;
    }

    public int countOneBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public boolean hasSameOneBits(int a, int b) {
        return countOneBits(a) == countOneBits(b);
    }

    public static void main(String[] args) {
        FindIfArrayCanBeSorted_3011 solution = new FindIfArrayCanBeSorted_3011();
        System.out.println(solution.canSortArray(new int[]{1, 2, 3, 4, 5}));
    }
}
