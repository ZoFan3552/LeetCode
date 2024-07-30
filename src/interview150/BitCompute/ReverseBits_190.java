package interview150.BitCompute;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/19 上午10:21
 */
public class ReverseBits_190 {
    public int reverseBits(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int bit = (n & mask) == 0 ? 0 : 1;
            res += (bit << (31 - i));
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new ReverseBits_190().reverseBits(43261596);
        System.out.println(res);
    }
}
