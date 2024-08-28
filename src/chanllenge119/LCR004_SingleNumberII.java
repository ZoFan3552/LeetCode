package chanllenge119;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 下午3:35
 */
public class LCR004_SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;

        // 考虑32位整数，每一位分别处理
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i; // 构造当前位的掩码

            // 统计所有数字在当前位上的1的个数
            for (int num : nums) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }

            // 如果这个位上的1的个数不是3的倍数，那么说明这个位是结果数的一部分
            if (sum % 3 != 0) {
                result |= mask; // 将该位的结果加入最终结果
            }
        }

        return result;
    }
}
