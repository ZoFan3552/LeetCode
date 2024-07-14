package interview150.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator_224 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();  // 使用栈来处理括号内的计算
        int operand = 0;  // 当前正在构建的数字
        int result = 0;   // 当前的计算结果
        int sign = 1;     // 正负号标志，1表示正，-1表示负
        char[] sCharArray = s.toCharArray();
        for (char ch : sCharArray) {
            if (Character.isDigit(ch)) {
                // 构建多位数的数字
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                // 遇到 '+' 运算符，计算之前的表达式结果
                result += sign * operand;

                // 更新符号为正
                sign = 1;
                // 重置当前数字
                operand = 0;
            } else if (ch == '-') {
                // 遇到 '-' 运算符，同样计算之前的表达式结果
                result += sign * operand;
                // 更新符号为负
                sign = -1;
                // 重置当前数字
                operand = 0;
            } else if (ch == '(') {
                // 遇到左括号，将当前结果和符号压入栈
                stack.push(result);
                stack.push(sign);

                // 重置符号和结果，准备计算括号内的表达式
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                // 遇到右括号，完成括号内的表达式计算
                result += sign * operand;

                // 栈顶的符号是这个括号内表达式的符号
                result *= stack.pop(); // 弹出符号并乘以结果

                // 栈顶的值是括号外之前的计算结果
                result += stack.pop(); // 弹出结果并加到当前结果上

                // 重置当前数字
                operand = 0;
            }
        }
        return result + (sign * operand);  // 最后返回计算结果
    }

    public static void main(String[] args) {
        BasicCalculator_224 basicCalculator224 = new BasicCalculator_224();
        int calculate = basicCalculator224.calculate(("1-(     -2)"));
        System.out.println(calculate);
    }


}

