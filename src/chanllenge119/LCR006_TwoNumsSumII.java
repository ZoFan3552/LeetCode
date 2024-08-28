package chanllenge119;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 下午4:16
 */
public class LCR006_TwoNumsSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 , right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else {
                return new int[]{left,right};
            }
        }
        return null;
    }
}
