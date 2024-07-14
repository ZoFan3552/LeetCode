package interview150.ArrayAndString;

import java.util.Arrays;

public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // 创建足够数量的StringBuilder来存储每一行的字符
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0; // 当前行
        boolean goingDown = false; // 当前的方向

        // 遍历字符串的每个字符
        for (char c : s.toCharArray()) {
            rows[curRow].append(c); // 将字符添加到当前行

            // 当我们在第一行或最后一行时，改变方向
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1; // 根据方向增加或减少行号
        }

        // 将所有行合并成一个字符串
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String res = new ZigzagConversion_6().convert("PAYPALISHIRING", 4);
        System.out.println(res);
    }
}
