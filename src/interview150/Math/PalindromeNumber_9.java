package interview150.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/20 下午2:46
 */
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;//负数不可能
        //利用数学方法得到每一位数字
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        if (list.size() == 1) return true;
        if (list.get(0) == 0) return false;
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
