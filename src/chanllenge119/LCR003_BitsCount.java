package chanllenge119;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 下午1:31
 */
public class LCR003_BitsCount {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //i 和 i >> 1 的二进制表示只有一位不同（最低位）
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
