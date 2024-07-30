package interview150.BitCompute;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/19 上午10:44
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
