package interview150.Math;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/21 下午2:00
 */
public class X_Sqrt {
    /**
     * 使用牛顿法计算非负整数平方根的整数部分。
     *
     * @param number 要计算平方根的非负整数
     * 返回输入数字平方根的整数部分
     */
    public  int mySqrt(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        //Xn+1 = ( Xn + number / Xn ) / 2;
        long guess = number;
        while (true) {
            long nextGuess = (guess + number / guess) / 2;
            if (nextGuess >= guess) {
                break;
            }
            guess = nextGuess;
        }
        return (int) guess;
    }
}
