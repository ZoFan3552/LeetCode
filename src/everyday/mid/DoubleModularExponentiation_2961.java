package everyday.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/30 上午11:22
 */
public class DoubleModularExponentiation_2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        //对乘法的结果求模，等价于先对每个因子都求模，然后对因子相乘的结果再求模。
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            int temp = helper(a , b , c , m);
            if (temp == target) {
                result.add(i);
            }
        }
        return result;
    }

    // 辅助函数：计算 (a^b % 10)^c % m
    private int helper(int a, int b, int c, int m) {
        // 计算 a^b % 10
        int res1 = superPowAndMod(a , b , 10);
        // 计算 (res1^c) % m
        return superPowAndMod(res1 , c , m);
    }

    // 快速幂函数：计算 (base^exponent) % mod
    private int superPowAndMod(int base, int exponent, int mod) {
        int result = 1;  // 初始化结果为 1
        base = base % mod;  // 将 base 取模，确保 base 小于 mod
        while (exponent > 0) {
            // 如果 exponent 是奇数，将 result 与当前 base 相乘并取模
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            exponent >>= 1;  // 将 exponent 右移一位，相当于整除 2
            base = (base * base) % mod;  // base 平方后取模
        }
        return result;  // 返回最终结果
    }


}
