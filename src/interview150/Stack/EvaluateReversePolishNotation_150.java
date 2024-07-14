package interview150.Stack;

import java.util.LinkedList;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        LinkedList<String> stack = new LinkedList<>();
        int res = 0;
        int rightNum = 0;
        int leftNum  = 0;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    rightNum = Integer.parseInt(stack.poll());
                    leftNum = Integer.parseInt(stack.poll());
                    int sum = leftNum + rightNum;
                    res = sum;
                    stack.push(String.valueOf(sum));
                }
                case "-" -> {
                    rightNum = Integer.parseInt(stack.poll());
                    leftNum = Integer.parseInt(stack.poll());
                    int sub = leftNum - rightNum;
                    res = sub;
                    stack.push(String.valueOf(sub));
                }
                case "*" -> {
                    rightNum = Integer.parseInt(stack.poll());
                    leftNum = Integer.parseInt(stack.poll());
                    int product = leftNum * rightNum;
                    res = product;
                    stack.push(String.valueOf(product));
                }
                case "/" -> {
                    rightNum = Integer.parseInt(stack.poll());
                    leftNum = Integer.parseInt(stack.poll());
                    int divide = leftNum / rightNum;
                    res = divide;
                    stack.push(String.valueOf(divide));
                }
                default -> stack.push(token);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new EvaluateReversePolishNotation_150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(res);
    }
}
