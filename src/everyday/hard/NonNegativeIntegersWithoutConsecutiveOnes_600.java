package everyday.hard;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/5 上午9:07
 */
public class NonNegativeIntegersWithoutConsecutiveOnes_600 {
    public int findIntegers(int n) {
        // 动态规划数组 dp[i] 表示长度为 i 且没有连续 1 的二进制字符串的数量
        int[] dp = new int[31];
        dp[0] = 1;  // 长度为 0 的二进制字符串只有一个情况: "0"
        dp[1] = 2;  // 长度为 1 的二进制字符串有两个情况: "0", "1"

        // 预计算 dp 数组
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int preBit = 0; // 记录前一位是否为 1
        int count = 0;  // 记录符合条件的数量

        // 从高位到低位遍历 n 的二进制表示
        for (int i = 29; i >= 0; i--) {
            int val = 1 << i; // 获取第 i 位的掩码值
            if ((n & val) != 0) { // 检查第 i 位是否为 1
                count += dp[i]; // 加上长度为 i 的所有没有连续 1 的二进制字符串的数量
                if (preBit == 1) {
                    return count; // 如果出现连续的 1，提前返回结果
                }
                preBit = 1; // 更新 preBit 为 1
            } else {
                preBit = 0; // 更新 preBit 为 0
            }
        }

        return count + 1; // 加上 n 本身
    }


    public static void main(String[] args) {
        int res = new NonNegativeIntegersWithoutConsecutiveOnes_600().findIntegers(1000000000);
        System.out.println(res);
    }
}
