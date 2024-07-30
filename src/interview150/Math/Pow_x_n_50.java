package interview150.Math;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/21 下午12:45
 */
public class Pow_x_n_50 {
    public double myPow(double x, int n) {
        //快速幂算法
        double res = 1.0;
        long absExponent = Math.abs((long) n);

        while (absExponent > 0) {
            if ((absExponent & 1) == 1) {//判断奇偶，只用看最低位是否为1
                //奇数就更新 res
                res *= x;
            }
            x *= x;//底数平方
            absExponent >>= 1;//指数减半
        }
        return n < 0 ? 1.0 / res : res;
    }

    public static void main(String[] args) {
    }
}
