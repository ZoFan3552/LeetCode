package interview150.Math;

import java.util.LinkedList;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/20 下午3:07
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        //考虑进位
        int n = digits.length;
        if (digits[n - 1] < 9){
            digits[n - 1]++;
            return digits;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int right = n - 1;
        while (right >= 0 && digits[right] == 9){
            stack.push(0);
            right--;
        }
        stack.push(1);
        for (int i = right; i >=0 ; i--) {
            if (i == right){
                stack.pop();
                stack.push(digits[i] + 1);
            }else {
                stack.push(digits[i]);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        new PlusOne_66().plusOne(new int[]{9});
    }
}
