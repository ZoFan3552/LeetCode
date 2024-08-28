package chanllenge119;

/**
 * @author: zeddic
 * @description: 两数相除
 * @date: 2024/8/24 下午9:08
 */
public class LCR001_TwoNumDivide {
    /**
     * 通过位运算实现两个整数的除法运算，不使用乘号 '*'、除号 '/' 和求余符号 '%'
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 商 a / b，如果结果溢出则返回 Integer.MAX_VALUE
     */
    public int divide(int dividend, int divisor) {
        // 边界情况处理：除数不能为0
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be 0");
        }

        // 边界情况处理：被除数为0时，结果为0
        if (dividend == 0) {
            return 0;
        }

        // 特殊情况：如果被除数是 Integer.MIN_VALUE 且除数是 -1，结果会超出32位整数范围
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 记录结果的符号：结果为负当且仅当被除数和除数符号不同
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // 将被除数和除数转换为正数，并使用 long 类型避免溢出
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // 记录最终的商
        int result = 0;

        // 通过位移操作来计算商
        for (int i = 31; i >= 0; i--) {
            // (absDividend >> i) >= absDivisor 表示 absDividend 是否大于或等于 absDivisor 的 2^i 倍
            if ((absDividend >> i) >= absDivisor) {
                // 如果是，则将结果加上 2^i
                result += 1 << i;

                // 并将 absDivisor 的 2^i 倍从 absDividend 中减去
                absDividend -= absDivisor << i;
            }
        }

        // 如果结果应该是负数，则返回负值的商，否则返回正值的商
        return isNegative ? -result : result;
    }
}
