package interview150.Math;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/21 上午11:55
 */
public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        /*
        计算阶乘数中所有能被 5整除的数的个数。
        计算阶乘数中所有能被 25整除的数的个数（每个这样的数贡献一个额外的因子 5）。
        继续计算阶乘数中所有能被
        125整除的数的个数，以此类推，直到阶乘数不再包含更多的因子 5。
         */
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
