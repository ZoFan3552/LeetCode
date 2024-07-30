package interview150.BitCompute;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/19 上午10:51
 */
public class BitwiseANDOfNumbersRange_201 {
    public int rangeBitwiseAnd(int left, int right) {
        //第一位的周期为1,第二位的周期为2,第三位为4....以此类推
        int length = right - left;
        //只有首尾都为1且长度小于等于周期时与运算为1
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if (right < (1 << i)) break;
            int circle = 1 << i;
            if ((left & mask) != 0 && (right & mask) != 0 && length <= circle) {
                res += (1 << i);
            }
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new BitwiseANDOfNumbersRange_201().rangeBitwiseAnd(2147483646, 2147483647);
        System.out.println(res);
    }
}
